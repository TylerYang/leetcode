public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) return Integer.MAX_VALUE; 
        
        long d = Math.abs((long) dividend);
        long s = Math.abs((long) divisor);
        long r = 0;
        while(d >= s) {
            long tmpS = s;
            long tmpR = 1;
            while(tmpS <= d){
                r += tmpR;
                d -= tmpS;
                
                tmpS <<= 1;
                tmpR <<= 1;
            }
        }
        int result = (int) r;
        return isPositiveResult(dividend, divisor) ? result : -result; 
    }
    private boolean isPositiveResult(int dividend, int divisor) {
        return (dividend > 0 && divisor > 0)||(dividend < 0 && divisor <0);
    }
}
