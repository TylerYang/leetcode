public class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0) return 0;
        if(s.charAt(0) == '0') return 0;
        if(s.length() == 1) return 1;
        int[] nArr = new int[2];
        nArr[0] = 1;
        if(isValid(s.charAt(1)) == false && isValid(s.charAt(0), s.charAt(1)) == false) return 0;
        nArr[1] = isValid(s.charAt(1)) && isValid(s.charAt(0), s.charAt(1)) ? 2 : 1;
            
        for(int i = 2; i < s.length(); i++) {
            int r = 0;
            if(isValid(s.charAt(i))) r += nArr[(i - 1) % 2];
            if(isValid(s.charAt(i - 1), s.charAt(i))) r += nArr[(i - 2) % 2];
            
            if(r == 0) return 0;
            
            nArr[i % 2] = r; 
        }
        return nArr[(s.length() - 1) % 2];
    }
    private boolean isValid(char c) {
        return c > '0' && c <= '9';
    }
    private boolean isValid(char pc, char c) {
        return pc == '1' || (pc == '2' && c >= '0' && c < '7');
    }
}
