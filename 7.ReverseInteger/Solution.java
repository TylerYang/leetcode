public class Solution {
    public int reverse(int x){
        int r = 0;
        while(x != 0){
            int currX = x % 10;
            try{
                r = safeMultiply(r, 10);
                r = safeAdd(r, currX);
            } catch(ArithmeticException e){
                return 0;
            }
            x /= 10;
        }
        return r;
    }
    private int safeMultiply(int x, int y){
        if(x == 0 || y == 0) return 0;
        int r = x * y;
        if(r / x != y){
           throw new ArithmeticException(); 
        } else {
            return r;
        }        
    }
    private int safeAdd(int x, int y){
        if(x == 0 || y == 0) return x + y;
        long r = ((long) x) + y;
        if(r > Integer.MAX_VALUE || r < Integer.MIN_VALUE){
            throw new ArithmeticException();
        } else {
            return (int)r;
        }
    }
    public static void main(String[] args){
        int input = 123512313;
        Solution sol = new Solution();
        System.out.println(sol.reverse(input));
    }
}
