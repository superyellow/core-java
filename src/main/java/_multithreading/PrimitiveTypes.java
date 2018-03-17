package _multithreading;

/**
 * Created by huangchao on 18/3/17.
 */
public class PrimitiveTypes {
    public static void main(String[] args) {
        //char
        System.out.println("\u2122");
        System.out.println(Character.isJavaIdentifierPart('\u2122'));
        System.out.println(Character.isJavaIdentifierStart('\u2122'));

        Long a = 123_456_1l;
        int i = 123_4;
        System.out.println("\n");
        System.out.println(a);
        System.out.println(i);
    }
}
