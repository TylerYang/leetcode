public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> re = new ArrayList<Integer>();
        if (words.length == 0 || words.length * words[0].length() > s.length()) return re;
        int count = 0, sLen = s.length(), wordsLen = words.length, wLen = words[0].length();
        Map<String, Integer> map = new HashMap<String, Integer>();
        Map<String, Integer> currMap = new HashMap<String, Integer>();
        for (String w: words) {
            if(map.containsKey(w)) {
                map.put(w, map.get(w) + 1);
            } else {
                map.put(w, 1);
            }
        }
        
        for (int i = 0; i < wLen; i++) {
            for (int l = i, r = i; r + wLen <= sLen; r += wLen) {
                String tmp = s.substring(r, r + wLen);
                if (map.containsKey(tmp)) {
                    if (currMap.containsKey(tmp)) {
                        currMap.put(tmp, currMap.get(tmp) + 1);
                        
                        while (currMap.get(tmp) > map.get(tmp)) {
                            String leftTmp = s.substring(l, l + wLen);
                            currMap.put(leftTmp, currMap.get(leftTmp) - 1);
                            l += wLen;
                            count--;
                        }
                    } else {
                        currMap.put(tmp, 1);
                    }
                    count++;
                    if (count == wordsLen) {
                        re.add(l);
                        
                        l += wLen;
                        String leftTmp = s.substring(l - wLen, l);
                        currMap.put(leftTmp, currMap.get(leftTmp) - 1);
                        
                        count--;
                    }
                } else {
                    l = r + wLen;
                    count = 0;
                    currMap.clear();
                }
            }
            currMap.clear();
            count = 0;
        }
        return re;
    }
}
