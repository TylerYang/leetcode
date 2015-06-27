import java.util.Comparator;
import java.util.Arrays;
public class MyPriorityQueue<AnyType> {
    private Object[] queue;
    private int size;
    private Comparator<? super AnyType> comparator;
    private final static int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    
    public MyPriorityQueue(int initialCapacity, Comparator<? super AnyType> comparator) {
        if(initialCapacity <= 0) throw new IllegalArgumentException();
        this.queue = new Object[initialCapacity];
        this.comparator = comparator;
    }
    
    public boolean add(AnyType item){ 
        return offer(item);
    }
    public int size() {
        return size;
    }
    public AnyType poll() {
        if(queue.length == 0) return null;
        int s = --size;
        AnyType r = (AnyType) queue[0];
        AnyType item = (AnyType) queue[s];
        queue[s] = null;
        if(s != 0) siftDown(0, item);
        return r;
    }
    private boolean offer(AnyType item){ 
        if(item == null) throw new NullPointerException();
        int i = size;
        if(i + 1 >= queue.length) grow(i + 1);
        
        size = i + 1;
        if(i == 0){
            queue[0] = item;
        } else {
            siftUp(i, item);
        }
        return true;
    }
    
    private void grow(int minCapacity) {
        int oldCapacity = queue.length;
        int newCapacity = oldCapacity;
        newCapacity += oldCapacity < 64 ? (oldCapacity * 2):(oldCapacity>>> 1);
        if(newCapacity > MAX_ARRAY_SIZE) newCapacity = getProperCapacity(minCapacity);
        
        queue = Arrays.copyOf(queue, newCapacity);
    }

    private int getProperCapacity(int minCapacity) {
        if(minCapacity <= 0) throw new OutOfMemoryError();
        return minCapacity > MAX_ARRAY_SIZE ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
    }

    private void siftUp(int k, AnyType item) {
        while(k > 0) {
            int parent = (k - 1) >> 1;
            Object c = queue[parent];
            if(comparator.compare(item, (AnyType) c) > 0 ) break; 
            queue[k] = c;
            k = parent;
        }
        queue[k] = item;
    }

    private void siftDown(int k, AnyType item) {
        int half = size >>> 1;
        while(k < half) {
            int child = (k << 1) + 1;
            Object c = queue[child];
            int right = child + 1;
            if(right < size && comparator.compare((AnyType) c , (AnyType) queue[right]) > 0) c = queue[child = right];
            if(comparator.compare(item, (AnyType) c) < 0) break;
            queue[k] = c;
            k = child;
        }
        queue[k] = item;
    }
    public static void main(String[] args) {
        ListNode[] lists = new ListNode[4];
        lists[0] = new ListNode(9);
        lists[1] = new ListNode(4);
        lists[2] = new ListNode(7);
        lists[3] = new ListNode(1);
        MyPriorityQueue<ListNode> pq = new MyPriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });
        for(int i = 0; i < lists.length; i++){
            pq.add(lists[i]);
        }

        while(pq.size() > 0) {
            ListNode node = pq.poll();
            System.out.println(node.val);
        }
        
    }
}
