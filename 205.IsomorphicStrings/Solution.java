public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        if(s.length() <= 1) return true;
        Map<Character, Character> charMap = new HashMap<Character, Character>();
        Set<Character> usedCharMap = new HashSet<Character>();
        
        StringBuffer sBuff = new StringBuffer();
        for(int i = 0; i < t.length(); i++) {
            if(charMap.containsKey(t.charAt(i))) {
                sBuff.append(charMap.get(t.charAt(i)));
            } else {
                if(usedCharMap.contains(s.charAt(i))) return false;
                
                sBuff.append(s.charAt(i));
                charMap.put(t.charAt(i), s.charAt(i));
                usedCharMap.add(s.charAt(i));
            }
        }
        return s.equals(sBuff.toString());
    }
}