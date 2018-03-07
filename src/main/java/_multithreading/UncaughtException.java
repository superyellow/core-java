package _multithreading;

/**
 * @author simple_huang@foxmail.com on 2017/10/24.
 */
public class UncaughtException {
    public static void main(String[] args) throws InterruptedException {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("group catch an exception : " + e.getMessage() + "thread name : " + Thread.currentThread().getName() + " group name is " + Thread.currentThread().getThreadGroup().getName());
            }
        });
        Thread t = new Thread(new UncaughtException.Run(), "Thread0");
        t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("personal catch an exception : " + e.getMessage() + "thread name : " + Thread.currentThread().getName());
            }
        });
        Thread t2 = new Thread(new ThreadGroup("threadGroup"), () -> System.out.println(10/0), "Thread1");

        t.start();
        t2.start();

        new Thread(new BadGroup("badGroup"), () -> {int i = 1/0;}, "Thread2").start();

//        System.out.println(10/0);

        System.out.println("end");

        Thread.sleep(2000);
        mainGroup();
    }

    static class Run implements Runnable{
        @Override
        public void run() {
            System.out.println("runnable run ---");
            int i = 10/0;
        }
    }

    public static void mainGroup() {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("i catch an exception - " + Thread.currentThread().getName() + " group name is " + Thread.currentThread().getThreadGroup().getName() + " exception is " + e.getMessage());
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("floor one : " + Thread.currentThread().getName() + " group name is " + Thread.currentThread().getThreadGroup().getName());
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("floor two : " + Thread.currentThread().getName() + " group name is " + Thread.currentThread().getThreadGroup().getName());
                        int i = 10/0;
                    }
                }, "thread3").start();
            }
        }, "thread4").start();
    }
}

class BadGroup extends ThreadGroup {

    public BadGroup(String name) {
        super(name);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("bad group catch exception : " + e.getMessage() + " thread name : " + Thread.currentThread().getName());
    }
}
