/**
 * @author simple_huang@foxmail.com on 2017/10/18.
 */
public class Test {
    public static void main(String[] args) {
        int x = 0;
        int dx = 2;
        x += dx;
        System.out.println(x);
        x += dx;
        System.out.println(x);


        String str = "1234567890111";
        int n = 4;
        System.out.println(str.substring(str.length()-n));
        System.out.println(str.substring(str.length()-n, str.length()-1));

        printOut(98349);
    }

    public static void printOut(int n) {
        if (n >= 10)
            printOut(n/10);
        System.out.print(n%10);
    }
    public void method() {
    }
}
