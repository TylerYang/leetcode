public class Solution2 {
    public String multiply(String num1, String num2) {
        if(num1.length() == 0 || num2.length() == 0) return "";
        if(num1.charAt(0) == '0' || num2.charAt(0) =='0') return "0";
        
        StringBuffer sBuff = new StringBuffer();
        int num = 0;
        for(int i = num1.length() + num2.length(); i > 0; i--) {
            for(int j = Math.min(i - 1, num1.length()); j > 0; j--) {
                if(i - j <= num2.length()) {
                    num += (int)(num1.charAt(j - 1) - '0') * (int)(num2.charAt(i - 1) - '0');
                }
            }
            if(i != 1 || num > 0) sBuff.append(num % 10);
            num /= 10;         
        }
        return sBuff.reverse().toString();
    }
}
