package _reflection;

/**
 * @author simple_huang@foxmail.com on 2018/3/7.
 */
public class R_getClassName {
    public static void main(String[] args) {
        System.out.println(new R_getClassName().getClass().getName());//1
        Object o = new R_getClassName();
        System.out.println(o.getClass().getName());
        System.out.println(R_getClassName.class.getName());//2

        try {
            Class clazz = Class.forName("_reflection.R_getClassName");//3
            clazz.getName();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(Double[].class.getName());
        System.out.println(int[].class.getName());

        try {
            Class.forName("int").getName();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String str = "java.util.Date";
        try {
            System.out.println(Class.forName(str).newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
