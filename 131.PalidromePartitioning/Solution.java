public class Solution {
    public List<List<String>> partition(String s) {
        return genPartition(s, 0);
    }
    private List<List<String>> genPartition(String s, int start) {
        List<List<String>> rlist = new ArrayList<List<String>>();
        if(start == s.length() - 1) {
            List<String> slist = new ArrayList<String>();
            slist.add(s.substring(start));
            rlist.add(slist);
            return rlist;
        }
        for(int i = start; i < s.length(); i++) {
            if(isPartition(s, start, i)) {
                if(i < s.length() - 1) {
                    List<List<String>> subList = genPartition(s, i + 1);
                    for(int j = 0; j < subList.size(); j++) {
                        List<String> slist = new ArrayList<String>();
                        slist.add(s.substring(start, i + 1));  
                        slist.addAll(subList.get(j));
                        rlist.add(slist);
                    }    
                } else {
                    List<String> slist = new ArrayList<String>();
                    slist.add(s.substring(start, i + 1));
                    rlist.add(slist);
                }
            }
        }
        return rlist;
    }
    private boolean isPartition(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}