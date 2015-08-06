public class LRUCache {
    int capacity, size;
    Map<Integer, ListNode> nodeMap;
    ListNode head, end;
    
    public LRUCache(int capacity) {
        //check arguments here
        this.size = 0;
        this.capacity = capacity;
        this.nodeMap = new HashMap<Integer, ListNode>();
    }
    
    public int get(int key) {
        if(nodeMap.containsKey(key)) {
            ListNode curr = nodeMap.get(key);
            if(curr == head && head.next != null) head = head.next;
            
            if(curr != end) {
                if(curr.prev != null) curr.prev.next = curr.next;
                if(curr.next != null) curr.next.prev = curr.prev;
            
                curr.prev = end;
                end.next = curr;
                curr.next = null;
                
                end = curr;    
            }
            
            return curr.val;
        } else {
            return -1;
        }
        
    }
    
    public void set(int key, int value) {
        if(nodeMap.containsKey(key)) {
            ListNode curr = nodeMap.get(key);
            curr.val = value;
            
            if(curr == head && head.next != null) head = head.next;
            
            if(curr != end) {
                if(curr.prev != null) curr.prev.next = curr.next;
                if(curr.next != null) curr.next.prev = curr.prev;
                
                curr.prev = end;
                curr.next = null;
                end.next = curr; 
                
                end = curr;
            }
        } else {
            ListNode curr = new ListNode(key, value);
            
            if(end != null) {
                end.next = curr;    
                curr.prev = end;
            }
            end = curr;
            
            if(head == null) {
                head = curr;
            }
            
            nodeMap.put(key, curr);
            
            if(size < capacity) {
                size++;
            } else {
                nodeMap.remove(head.key);
                ListNode tmp = head;

                head = head.next;
                
                head.prev = null;
                tmp.next = null;
            }
        }
    }
    
    private class ListNode {
        int key, val;
        ListNode prev, next;
        public ListNode(int key, int val) { 
            this.key = key;
            this.val = val;
        }
    }
}