public class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        if(s.length() == 0) return "";
        StringBuffer sBuff = new StringBuffer();
        int lastPos = s.length();
        for(int i = s.length() - 1; i >= 0; i--) {
            if(i == 0 || s.charAt(i - 1) == ' ' ) {
                sBuff.append(s.substring(i, lastPos));
            
                if(i != 0) {
                    sBuff.append(" ");
                    while(i > 0 && s.charAt(i - 1) == ' ') {
                        i--;
                    }
                }
                lastPos = i;
            }
        }
        return sBuff.toString();
    }
}