package _reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author simple_huang@foxmail.com on 2018/3/7.
 */
public class ReflectionTest {
    public static void main(String[] args) {
        String name = "java.lang.Double";

        try {
            //print class name and superclass name
            Class clazz = Class.forName(name);
            Class superClazz = clazz.getSuperclass();
            String modifiers = Modifier.toString(clazz.getModifiers());
            if (modifiers.length()>0) System.out.print(modifiers + " ");
            System.out.print("class " + name);
            if (superClazz!=null && superClazz!=Object.class) System.out.print(" extends " + superClazz.getName());
            System.out.print("\n{\n");
            printConstructors(clazz);
            System.out.println();
            printMethods(clazz);
            System.out.println();
            printFields(clazz);
            System.out.println("}");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.exit(0);
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
            System.out.print(name + "(");

            //print parameter types
            Class[] paraTypes = c.getParameterTypes();
            for (int i=0; i<paraTypes.length; i++) {
                if (i > 0) System.out.print(", ");
                System.out.print(paraTypes[i].getName());
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

            System.out.print("   ");
            //print modifiers, return type and method name
            String modifiers = Modifier.toString(m.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print(retType.getName() + " " + name + "(");

            //print parameter types
            Class[] paramTypes = m.getParameterTypes();
            for (int i=0; i<paramTypes.length; i++) {
                if (i>0) System.out.print(", ");
                System.out.print(paramTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * print all fields of a class
     * @param clazz
     */
    public static void printFields(Class clazz) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field: fields) {
            Class type = field.getType();
            String name = field.getName();
            System.out.print("   ");
            String modifiers = Modifier.toString(field.getModifiers());
            if (modifiers.length()>0) System.out.print(modifiers + " ");
            System.out.println(type.getName() + " " + name + ";");
        }
    }
}
