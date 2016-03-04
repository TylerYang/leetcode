import java.util.List;
import java.util.ArrayList;
public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        PeekingIterator it = new PeekingIterator(list.iterator());
        System.out.println("peek:" + it.peek());
        while(it.hasNext()) {
            System.out.println(it.next());
            System.out.println("peek:" + it.peek());
        }
    }
}
