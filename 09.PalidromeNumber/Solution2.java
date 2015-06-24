public class Solution2 {
    //generic solution
    public boolean isPalindrome(int x) {
        int base = getBase(x);
        while(x != 0){
            int left = x / base;
            int right = x % 10;
            if(left != right) return false;
           
            x = x % base / 10; 
            base /= 100;
        }
        return true;
    }
    private int getBase(int x){
        int count = 1;
        while(x > 9){
            x /= 10;
            count *= 10;
        }
        return count;
    }
    public static void main(String[] args){
        int input = 1000030001;
        Solution2 sol = new Solution2();
        System.out.println(sol.isPalindrome(input));
    }
}
    
