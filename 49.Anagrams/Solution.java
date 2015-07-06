import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
public class Solution {
    public List<String> anagrams(String[] strs) {
        List<String> rList = new ArrayList<String>();
        if(strs.length <= 1) return rList;
        Map<String, List<String>> anaMap = new HashMap<String, List<String>>();
        for(int i = 0; i < strs.length; i++) {
            String s = sort(strs[i]);
            if(anaMap.containsKey(s)){
                List<String> tmpList = anaMap.get(s);
                tmpList.add(strs[i]);
            } else {
                List<String> tmpList = new ArrayList<String>();
                tmpList.add(strs[i]);
                anaMap.put(s, tmpList);
            }
        }
        
        for(List<String> list : anaMap.values()) {
            if(list.size() > 1) rList.addAll(list);
        }
        return rList;
    }
    private String sort(String s) {
        char[] cArr = s.toCharArray();
        Arrays.sort(cArr);
        return new String(cArr);
    }
}
