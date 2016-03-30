public class Solution {
    public boolean isMatch(String s, String p) {
        //s: abc    p: ab*c
        int star = -1, ss = 0, sp = 0, pp = 0;
        //sp: 2,  pp: 3
        //ss: 2
        while(sp < s.length()) {
            if(pp < p.length()) {
                if(p.charAt(pp) == '*') {
                    //star: 2
                    star = pp++;
                    ss = sp;
                    continue;
                }

                if(p.charAt(pp) == '?' || p.charAt(pp) == s.charAt(sp)) {
                    pp++;
                    sp++;
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
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "abc";
        String p = "ab*c";

        System.out.println(sol.isMatch(s, p));
    }
}
