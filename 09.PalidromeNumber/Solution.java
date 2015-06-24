public class Solution {
    public boolean isPalindrome(int x) {
        if(x == 0) return true;
        if(x < 0) return false;
        return x == reverse(x);
    }
    private int reverse(int x) {
        int r = 0;
        while(x != 0){
            int currN = x % 10;
            try{
                r = safeMultiply(r, 10);
                r = safeAdd(r, currN);
            } catch (ArithmeticException e){
                r = 0;
                break;
            }
            x /= 10;
        }
        return r;
    }
    private int safeMultiply(int x, int y) throws ArithmeticException{
        if(x == 0 || y == 0) return 0;
        int r = x * y;
        if(r / x != y){
            throw new ArithmeticException();
        } else {
            return r;       
        } 
    }
    private int safeAdd(int x, int y) throws ArithmeticException{
        if(x == 0 || y == 0) return x + y;
        long r = ((long) x) + y;
        if(r > Integer.MAX_VALUE || r < Integer.MIN_VALUE){
            throw new ArithmeticException();
        } else {
            return (int)r;
        }
    }
}
