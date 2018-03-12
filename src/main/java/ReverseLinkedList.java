import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by huangchao on 18/3/5.
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("tom");
        list.add("jimmy");
        list.add("lily");
        System.out.println(list);

        ListIterator<String> iter = list.listIterator(list.size());
        while (iter.hasPrevious()) {
            System.out.println(iter.previous());
        }
    }
}
