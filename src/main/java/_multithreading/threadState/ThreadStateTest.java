package _multithreading.threadState;

import java.util.Arrays;

/**
 * @author simple_huang@foxmail.com on 2017/10/24.
 */
public class ThreadStateTest {
    public static void main(String[] args) {
//        testStateAfterSleep();
        testStateAfterWait();
    }

    public static void testStateAfterSleep() {
        Arrays.asList(10, 20, 30).stream().forEach(integer -> {
            Thread t = new Thread(() -> {
                System.out.println(integer);
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(integer);
            });
            System.out.println(t.getName() + " " + t.getState());
            t.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(t.getName() + " " + t.getState());
        });
    }

    public static void testStateAfterWait() {
        Thread t = new Thread(() -> {
            System.out.println("wait1");
            try {
                Thread.currentThread().wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("wait2");
        });
        System.out.println(t.getState());
        t.start();
        try {
            Thread.sleep(1000);
            Thread.currentThread().setPriority(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t.getState());
    }
}
