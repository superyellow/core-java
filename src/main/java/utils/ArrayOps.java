package utils;

import java.util.Arrays;

/**
 * @author simple_huang@foxmail.com on 2018/3/22.
 */
public class ArrayOps {
    public static int[] delArrayElement(int[] original, int index) {
        if (index<0 || index>original.length) {
            throw new IllegalArgumentException("del index > " + original.length);
        }
        if (index == original.length-1) {
            return Arrays.copyOfRange(original, 0, original.length-1);
        }
        System.arraycopy(original, index+1, original, index, original.length-index-1);
        return Arrays.copyOfRange(original, 0, original.length-1);
    }

    public static void printArray(int[] original) {
        for (int i: original) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        int[] is = {3, 5, 1, 2};
        is = delArrayElement(is, 0);
        printArray(is);
    }
}
