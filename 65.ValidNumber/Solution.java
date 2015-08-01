public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        if(s.length() == 0) return false;
        int state = 0, flag = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(isCharacter(c)) {
                if(state == 0 || state == 5) {
                    state++;
                } else {
                    return false;
                }
           } else if(isDigest(c)) {
                 if(state <= 2){ 
                    state = 2; 
                    flag = 1;
                } else if(state <= 4) {
                    state = 4;
                    flag = 1;
                } else if(state >= 5) {
                    state = 7;
                }
            } else if(isDot(c)) {
                if(state <= 2) {
                    state = 3;
                } else {
                    return false;
                }   
            } else if(isExponent(c)) {
                if(2 <= state && state <= 4) {
                    state = 5;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return flag == 1 && (state == 2 || state == 3 || state == 4 || state == 7);
   }
   private boolean isCharacter(char c) {
       return c == '+' || c == '-';
   }
   private boolean isDigest(char c) {
       return '0' <= c && c <= '9';
   }
   private boolean isDot(char c) {
       return c == '.';
   }
   private boolean isExponent(char c) {
       return c == 'e' || c == 'E';
   }
    
}
