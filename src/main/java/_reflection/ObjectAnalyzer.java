package _reflection;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 * @author simple_huang@foxmail.com on 2018/3/8.
 */
public class ObjectAnalyzer {
    private ArrayList<Object> visited = new ArrayList<>();

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=1; i<=5; i++) {
            list.add(i*i);
        }
        System.out.println(new ObjectAnalyzer().toString(list));
    }

    public String toString(Object obj) {
        if (obj == null) return "null";
        if (visited.contains(obj)) return "...";
        visited.add(obj);
        Class clazz = obj.getClass();
        if (clazz == String.class) return (String) obj;
        if (clazz.isArray()) {
            String r = clazz.getComponentType() + "[]{";
            for (int i=0; i< Array.getLength(obj); i++) {
                if (i>0) r += ",";
                Object val = Array.get(obj, i);
                if (clazz.getComponentType().isPrimitive()) r += val;
                else r += toString(val);
            }
            return r += "}";
        }

        String r = clazz.getName();
        do {
            r += "[";
            Field[] fields = clazz.getDeclaredFields();
            AccessibleObject.setAccessible(fields, true);
            //get the name and value of all field
            for (Field field: fields) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    if (!r.endsWith("[")) r += ",";
                    r += field.getName() + "=";
                    try {
                        Class type = field.getType();
                        Object val = field.get(obj);
                        if (type.isPrimitive()) r += val;
                        else r += toString(val);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            r += "]";
            clazz = clazz.getSuperclass();
        } while (clazz != null);
            return r;
    }
}
