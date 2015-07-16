public class Solution2 {
    public boolean isScramble(String s1, String s2) {
        if(s1.length() == 0) return s2.length() == 0;
        if(s1.length() != s2.length()) return false;
        boolean[][][] res = new boolean[s1.length()][s1.length()][s1.length() + 1];
        for(int i = 0; i < s1.length(); i++) {
            for(int j = 0; j < s2.length(); j++) {
                res[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }
        for(int len = 2; len < s1.length() + 1; len++) {
            for(int i = 0; i < s1.length() - len + 1; i++) {
                for(int j = 0; j < s2.length() - len + 1; j++) {
                    for(int k = 1; k < len; k++) {
                        res[i][j][len] |= (res[i][j][k] && res[i][j][len - k]) || (res[i][j + len - k][k] && res[i + k][j][len - k]);
                    }
                }
            }
        }
        return res[0][0][s1.length()];
    }
}
