public class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        //if(s.length() == t.length()) return s.equals(t) ? s : "";
        Map<Character, Integer> tMap = new HashMap<Character, Integer>();
        Map<Character, Integer> cMap = new HashMap<Character, Integer>();
        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            cMap.put(c, 0);
            if(tMap.containsKey(c))  {
                tMap.put(c, tMap.get(c) + 1);
            } else {
                tMap.put(c, 1);
            }
        }
        int i = 0, j = 0, start = -1, end = -1, min = Integer.MAX_VALUE, count = 0;
        while(j < s.length()) {
            char c = s.charAt(j);
            char sc = s.charAt(i);
            if(tMap.containsKey(c)) {
                cMap.put(c, cMap.get(c) + 1);
                if(cMap.get(c) <= tMap.get(c)) {
                    count++;
                }
            }
            while(i <= j && (tMap.containsKey(sc) == false || cMap.get(sc) > tMap.get(sc))) {
                if(cMap.containsKey(sc)) cMap.put(sc, cMap.get(sc) - 1);
                i++;
                if(i <= j) sc = s.charAt(i);
            }
            if(count == t.length() && j - i + 1 < min) {
                min = j - i + 1;
                start = i;
                end = j + 1;
            }
            j++;
        }
        if(start != -1) return s.substring(start, end);
        return "";
    }
}