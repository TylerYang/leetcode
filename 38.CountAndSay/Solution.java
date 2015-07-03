public class Solution {
    public String countAndSay(int n) {
        if(n == 1) return "1";
        String r = "1";
        for(int i = 2; i <= n; i++) {
            r = getNextStr(r);
        }
        return r;
    }
    private String getNextStr(String s) {
        char c = s.charAt(0);
        int count = 1;
        StringBuffer sBuff = new StringBuffer();
        for(int i = 1; i < s.length(); i++) {
            char currC = s.charAt(i);
            if(c == currC) {
                count++;
            } else {
                sBuff.append(count);
                sBuff.append(c);
                c = currC;
                count = 1;
            }
        }

        sBuff.append(count);
        sBuff.append(c);
        
        return sBuff.toString();
        
    }
}
