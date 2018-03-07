package _reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author simple_huang@foxmail.com on 2018/3/7.
 */
public class ReflectionTest {
    public static void main(String[] args) {

    }

    /**
     * print all constructors of a class
     * @param clazz
     */
    public static void printConstructors(Class clazz) {
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor c: constructors) {
            String name = c.getName();
            System.out.print("   ");
            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.println(name + "(");

            //print parameter types
            Class[] paraTypes = c.getParameterTypes();
            for (int i=0; i<paraTypes.length; i++) {
                if (i > 0) System.out.println(", ");
                System.out.println(paraTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * print all methods of a class
     * @param clazz
     */
    public static void printMethods(Class clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m: methods) {
            Class retType = m.getReturnType();
            String name = m.getName();

            System.out.println("   ");

        }
    }
}
