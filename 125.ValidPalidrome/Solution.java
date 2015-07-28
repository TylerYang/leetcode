public class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() <= 1) return true;
        int i = 0, j = s.length() - 1;
        while(i < j) {
            while(isAlphaNumeric(s.charAt(i)) == false && i < j) {
                i++;
            }
            while(isAlphaNumeric(s.charAt(j)) == false && j > i) {
                j--;
            }
            if(i >= j) break;
            if(isSameChar(s.charAt(i), s.charAt(j)) == false) return false;
            i++;
            j--;
        }
        return true;
    }
    private boolean isAlphaNumeric(char c) {
        return  isNumeric(c) || (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }
    private boolean isNumeric(char c) {
        return c >= '0' && c <= '9';
    }
    private boolean isSameChar(char a, char b) {
        if(isNumeric(a) || isNumeric(b)) {
            return a == b;
        } else {
            if(a >= 'A' && a <= 'Z') {
                a = (char)(a + 32);
            }
            if(b >= 'A' && b <= 'Z') {
                b = (char)(b + 32);
            }
            return a == b;
        }
    }
}