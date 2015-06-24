public class Solution {
    public int myAtoi(String str) {
        int sign = 0, i = 0, r = 0;
        str = str.trim();
        while(i < str.length()) {
            char currChar = str.charAt(i);
            int currCode = (int) currChar; 
            if((sign != 0 || r != 0) && !isNumber(currCode)){
                break;
            } else if(sign == 0 && isSign(currCode)){
                sign = currCode == '-'? -1 : 1;
            } else if(!isNumber(currChar)){
                break; 
            } else {
                int currN = getNumber(currCode);
                try{
                    r = safeMultiply(r, 10);
                    r = safeAdd(r, currN);
                } catch(ArithmeticException e){
                    if(sign == -1){
                        r = Integer.MIN_VALUE;
                        sign = 0;
                    } else {
                        r = Integer.MAX_VALUE;
                    } 
                    break;
                }
            }
            i++;
        }
        return sign == -1 ? r * -1 : r;
    }
    private boolean isNumber(int charCode){
        return charCode >= 48 && charCode <= 57;
    }
    private boolean isSign(int charCode){
        return charCode == 43 || charCode == 45;
    }
    private int getNumber(int charCode){
        return charCode - 48;
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
        boolean isPositive = x > 0 && y > 0;
        boolean isNegative = x < 0 && y < 0;
        
        int r = x + y;
        if((isPositive && r < 0) || (isNegative && r > 0)){
            throw new ArithmeticException();
        } else {
            return r;
        }
    }
    public static void main(String[] args){
        String input = "2147483648";
        Solution sol = new Solution();
        System.out.println(sol.myAtoi(input));
        
   }
}


