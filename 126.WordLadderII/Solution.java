public class Solution {
    Queue<String> queue;
    Map<String, Node> map;
    private class Node {
        LinkedList<Node> nextList;
        String val;
        int level;
        public Node(String str, int l) {
            this.val = str;
            this.level = l;
            this.nextList = new LinkedList<Node>();
        }
        public void addNext(Node nextNode) {
            this.nextList.add(nextNode);
        }
    }
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        queue = new LinkedList<String>();
        map = new HashMap<String, Node>();
        
        queue.add(end);
        Node node = new Node(end, 1);
        map.put(end, node);

        dict.remove(end);
        dict.add(start);
        
        return getLadders(start, dict);
    }
    private List<List<String>> getLadders(String end, Set<String> dict) {
        List<List<String>> rList = new ArrayList<List<String>>();
        while(queue.isEmpty() == false) {
            String start = queue.poll();
            
            if(start.equals(end)) break;
            
            char[] cArr = start.toCharArray();
            
            for(int i = 0; i < start.length(); i++) {
                for(char c = 'a'; c <= 'z'; c++) {
                    if(cArr[i] == c) continue;
                    cArr[i] = c;
                    String newStr = new String(cArr);
                    if(dict.contains(newStr)) {
                        Node nextNode = map.get(start);
                        int nextLevel = nextNode.level;
                        
                        if(map.containsKey(newStr)) {
                            Node currNode = map.get(newStr);
                            if(currNode.level == nextLevel + 1) {
                                currNode.addNext(nextNode);
                            }
                        } else {
                            Node currNode = new Node(newStr, nextLevel + 1);
                            currNode.addNext(nextNode);
                            map.put(newStr, currNode);
                            queue.add(newStr);
                        }
                        
                    }
                    cArr[i] = start.charAt(i);
                }
            }
        }
        if(map.containsKey(end)) getPath(map.get(end), new ArrayList<String>(), rList);

        return rList;
    }
    private void getPath(Node currNode, List<String> sList, List<List<String>> rList) {
        sList.add(currNode.val);
        if(currNode.nextList.size() == 0) {
            rList.add(sList);
            return;
        }   
        for(int i = 0; i < currNode.nextList.size(); i++) {
            getPath(currNode.nextList.get(i), new ArrayList<String>(sList), rList);
        }
    }
}