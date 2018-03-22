package _collections.interfaces;

import com.google.common.base.Optional;

/**
 * @author simple_huang@foxmail.com on 2018/3/5.
 */
public class MyLinkedListQueue<E> implements MyQueue<E> {
    @Override
    public void add(E e) {}

    @Override
    public E remove() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    public MyLinkedListQueue() {}

    private Link<E> head;
    private Link<E> tail;

    public class Link<E> {
        private E element;
        private Link<E> next;
    }
}
