package _collections.algorithms;

import java.util.*;

/**
 * @author simple_huang@foxmail.com on 2017/10/18.
 */
public class Max {
    /**
     * 求一个集合中的最大值
     * 提供一个可以接收任何实现了Collection接口的对象的方法
     * 参考Collections.max(Collection<? extends T></> coll)方法
     * @param c
     * @param <T>
     * @return
     */
    public static <T extends Comparable> T getMax(Collection<T> c) {
        if (c.isEmpty()) throw new NoSuchElementException();
        Iterator<T> iterator = c.iterator();
        T largest = iterator.next();
        while (iterator.hasNext()) {
            T next = iterator.next();
            if (largest.compareTo(next) < 0) {
                largest = next;
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(2, 7, 3, 1, 6);
        System.out.println(getMax(integers));
    }
}
