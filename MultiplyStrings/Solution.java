public class Solution {
    public String multiply(String num1, String num2) {
        if(num1.length() == 0 || num2.length() == 0) return "";
        if("0".equals(num1) || "0".equals(num2)) return "0";
        String r = "0";
        for(int i = num1.length() - 1; i >= 0; i--) {
            int n = (int) (num1.charAt(i) - '0');
            if(n != 0) {
                String tmpR = mul(num2, n, num1.length() - 1 - i);
                r = plus(tmpR, r);
            }
        } 
        return r;
    }
    private String mul(String num, int n, int zeroNum) {
        int inc = 0;
        StringBuffer sBuff = new StringBuffer();
        for(int i = num.length() - 1; i >= 0; i--) {
            int m = (int)(num.charAt(i) - '0');
            int r = m * n + inc;
            inc = 0;
            if(i != 0) {
                inc = r / 10;
                r %= 10;
            }
            sBuff.insert(0, r);
        }
        for(int i = 0; i < zeroNum; i++){
            sBuff.append("0");
        }
        return sBuff.toString();
    }
    private String plus(String num1, String num2) {
        if("0".equals(num1)) return num2;
        if("0".equals(num2)) return num1;
        int i = num1.length() - 1, j = num2.length() - 1, inc = 0;
        StringBuffer sBuff = new StringBuffer();
        
        while(i >= 0 || j >= 0) {
            int r = inc;
            inc = 0;
            if(i >= 0) r += (int)(num1.charAt(i--) - '0');
            if(j >= 0) r += (int)(num2.charAt(j--) - '0');
            if(i != -1 || j != -1) {
                inc = r / 10;
                r %= 10;
            }
            sBuff.insert(0, r);
        }
        return sBuff.toString();
    }
}
