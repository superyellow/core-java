package _collections.implement;

/**
 * @author simple_huang@foxmail.com on 2018/3/6.
 */
public class DoubleList<T> {
    private int size = 0;
    private Node<T> lastNode;
    private Node<T> firstNode;
    private Node<T> printNode;
    public void add(T t) {
        if (size == 0) {
            lastNode = firstNode = new Node<T>().setNext(null).setPrev(null).setT(t);
        } else {
            lastNode.setNext(new Node<T>().setPrev(lastNode).setNext(null).setT(t));
            lastNode = lastNode.getNext();
        }
        size++;
    }

    public class Node<T> {
        private Node next;
        private Node prev;
        T t;

        public Node getNext() {
            return next;
        }

        public Node<T> setNext(Node next) {
            this.next = next;
            return this;
        }

        public Node getPrev() {
            return prev;
        }

        public Node<T> setPrev(Node prev) {
            this.prev = prev;
            return this;
        }

        public T getT() {
            return t;
        }

        public Node<T> setT(T t) {
            this.t = t;
            return this;
        }
    }

    @Override
    public String toString() {
        printNode = firstNode;
        StringBuilder sb = new StringBuilder();
        while (printNode != null) {
            sb.append(printNode.getT() + ", ");
            printNode = printNode.getNext();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        DoubleList<String> list = new DoubleList<>();
        list.add("tom");
        list.add("jimmy");
        list.add("lily");
        System.out.println(list.toString().substring(0, list.toString().length()-2));
    }
}
