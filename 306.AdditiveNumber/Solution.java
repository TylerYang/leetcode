import java.math.BigInteger;
public class Solution {
    public boolean isAdditiveNumber(String num) {
        if(num.length() < 3) return false;
        int len = num.length(),  halfLen = num.length() / 2;
        for(int i = 1; i <= halfLen; i++) {
            if (num.charAt(0) == '0' && i > 1) return false;
            BigInteger x1 = new BigInteger(num.substring(0, i));
            for(int j = 1; Math.max(i, j) <= len - i - j; j++) {
                if(num.charAt(i) == '0' && j != 1) break;
                BigInteger x2 = new BigInteger(num.substring(i, i + j));
                if(isAdditive(x1, x2, num.substring(i + j))) return true;
            }
        }
        return false;
    }
    private boolean isAdditive(BigInteger num1, BigInteger num2, String num) {
        if(num.length() == 0) return true;

        num2 = num1.add(num2);
        num1 = num2.subtract(num1);

        String sum = num2.toString();
        return num.startsWith(sum) && isAdditive(num1, num2, num.substring(sum.length()));
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        String num = "123";
        System.out.println(sol.isAdditiveNumber(num));
    }
}
