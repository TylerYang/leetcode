public class Solution {
    public boolean isMatch(String s, String p) {
        int star = -1, ss = 0, sp = 0, pp = 0;
        while(sp < s.length()) {
            if(pp < p.length()) {
                if(p.charAt(pp) == '?' || p.charAt(pp) == s.charAt(sp)) {
                    pp++;
                    sp++;
                    continue;
                } 
                if(p.charAt(pp) == '*') {
                    star = pp++;
                    ss = sp;
                    continue;
                }
            }
            if(star != -1) {
                pp = star + 1;
                sp = ++ss;
                continue;
            }
            return false;
        }
        while(pp < p.length() && p.charAt(pp) == '*') pp++;
        
        return pp == p.length();
    }
}
