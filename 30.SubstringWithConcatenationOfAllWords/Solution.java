import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> rList = new ArrayList<Integer>();
        if(s.length() == 0 || words.length == 0 || words[0].length() == 0) return  rList;
        int sLen = s.length(), wLen = words[0].length();
        int wsLen = wLen * words.length;
        
        Map<String, Integer> wordsMap = new HashMap<String, Integer>();
        Map<String, Integer> foundMap = new HashMap<String, Integer>();
        for(int i = 0; i < words.length; i++) {
            if(wordsMap.containsKey(words[i])){
                wordsMap.put(words[i], wordsMap.get(words[i]) + 1);
            } else {
                wordsMap.put(words[i], 1);
            }
            foundMap.put(words[i], 0);
        }
          
        for(int i = 0; i < wLen; i++) {
            int start = i, end = start + wLen;
            while(end <= sLen) {
                String str = s.substring(end - wLen, end);
                if(wordsMap.containsKey(str)) {
                    if(wordsMap.get(str) == foundMap.get(str)) {
                        while(wordsMap.get(str) == foundMap.get(str)) {
                            String tmpStr = s.substring(start, start + wLen);
                            foundMap.put(tmpStr, foundMap.get(tmpStr) - 1);
                            start += wLen;
                        }     
                    } else {
                        if(end - start == wsLen) {
                            rList.add(start);
                            String tmpStr = s.substring(start, start + wLen); 
                            foundMap.put(tmpStr, foundMap.get(tmpStr) - 1);
                            start += wLen;
                        } 
                    }
                    foundMap.put(str, foundMap.get(str) + 1);
                } else {
                    start = end;
                    clearMap(foundMap);
                }
                end += wLen;
            }          
            clearMap(foundMap);
        }
        return rList;
    }
    private void clearMap(Map<String, Integer> foundMap) {
        Iterator<Map.Entry<String, Integer>> entries = foundMap.entrySet().iterator();
        while(entries.hasNext()) {
            Map.Entry<String, Integer> entry = entries.next();
            foundMap.put(entry.getKey(), 0);
        }
        
    }
}
