public class Solution {
    public int titleToNumber(String s) {
        int r = 0;
        for(int i = 0; i < s.length(); i++) {
            int base = (int) Math.pow(26, s.length() - i - 1);
            r += base * (s.charAt(i) - 'A' + 1);
        }
        return r;
    }
}