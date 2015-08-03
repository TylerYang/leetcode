import java.util.*;
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        Map<Integer, UndirectedGraphNode> gMap = new HashMap<Integer, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.add(node);

        while(queue.isEmpty() == false) {
            UndirectedGraphNode currNode = queue.poll();
            UndirectedGraphNode copyNode = null;
            if(gMap.containsKey(currNode.label)) {
                currNode = gMap.get(currNode.label); 
            } else {
                copyNode = new UndirectedGraphNode(currNode.label);
                gMap.put(currNode.label, copyNode);
            }
            Iterator<UndirectedGraphNode> it = currNode.neighbors.iterator();
            while(it.hasNext()) {
                UndirectedGraphNode ngNode = it.next();
                
                if(gMap.containsKey(ngNode.label)) {
                    copyNode.neighbors.add(gMap.get(ngNode.label)); 
                } else {
                    UndirectedGraphNode copyNgNode = new UndirectedGraphNode(ngNode.label);
                    copyNode.neighbors.add(copyNgNode);;
                    
                    gMap.put(ngNode.label, copyNgNode);
                    queue.add(ngNode);
                }
            }
        }
        return gMap.get(node.label);
    }
}
