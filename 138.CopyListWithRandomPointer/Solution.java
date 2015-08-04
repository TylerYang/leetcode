/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        Map<RandomListNode, RandomListNode> nodeMap = new HashMap<RandomListNode, RandomListNode>();
        Queue<RandomListNode> queue = new LinkedList<RandomListNode>();
        queue.add(head);
        while(queue.isEmpty() == false) {
            RandomListNode currNode = queue.poll();
            RandomListNode copyCurrNode = null;
            
            if(nodeMap.containsKey(currNode)) {
                copyCurrNode = nodeMap.get(currNode);
            } else {
                copyCurrNode = new RandomListNode(currNode.label);
                nodeMap.put(currNode, copyCurrNode);
            }
            
            
            if(currNode.next != null) {
                RandomListNode nextNode = currNode.next;
                if(nodeMap.containsKey(nextNode) == false) {
                    RandomListNode copyNextNode = new RandomListNode(nextNode.label);
                    queue.add(nextNode);
                    nodeMap.put(nextNode, copyNextNode);
                }
                copyCurrNode.next = nodeMap.get(nextNode);
            }
            if(currNode.random != null){ 
                RandomListNode randomNode = currNode.random;
                if(nodeMap.containsKey(randomNode) == false) {
                    RandomListNode copyRandomNode = new RandomListNode(randomNode.label);
                    queue.add(randomNode);
                    nodeMap.put(randomNode, copyRandomNode);
                }
                copyCurrNode.random = nodeMap.get(randomNode);
            }
            
        }
        return nodeMap.get(head);
    }
}