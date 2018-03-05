import java.io.IOException;

/**
 * @author simple_huang@foxmail.com on 2017/10/25.
 */
public class RuntimeLearn {
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        System.out.println("Total memory is " + r.totalMemory());
        System.out.println("Initial free memory is " + r.freeMemory());
        r.gc();
        long mem1 = r.freeMemory();
        System.out.println("free memory after gc " + mem1);
        Integer[] someints = new Integer[1000];
        for (int i = 0; i < 1000; i++) {
            someints[i] = i;
        }
        long mem2 = r.freeMemory();
        System.out.println("free memory after allocation " + mem2);
        System.out.println("memory used by allocation " + (mem1 - mem2));
        //discard integers
        for (int i=0; i<someints.length; i++) {
            someints[i] = null;
        }
        r.gc();
        System.out.println("free memory after discard integer " + r.freeMemory());

        Process p = null;
        Process p1 = null;
        try {
//            p = r.exec("cp /Users/wechat/hs_err_pid6343.log /Users/wechat/error.log");
//            p1 = r.exec("/Applications/Calculator.app/Contents/MacOS/Calculator");
//            p.waitFor();
//            p1.waitFor();
            //会进入互相等待

            p = r.exec("cp /Users/wechat/hs_err_pid6343.log /Users/wechat/error.log");
            p.waitFor();
            p1 = r.exec("/Applications/Calculator.app/Contents/MacOS/Calculator");
            p1.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println("returned " + p1.exitValue());
    }
}
