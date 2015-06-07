public class Solution{
    public String longestPalindrome(String s){
        //Brute force should better than n^3 
        int sLen = s.length();
        if(sLen <= 1) return s;
        int max = 1, start = 0, end = 1;
        for(int i = 0; i < sLen; i++){
            for(int j = sLen - 1; j - i + 1 > max; j--){
                if(isPalindrome(s, i, j)){
                    max = j - i + 1;
                    start = i;
                    end = j + 1;
                    break;
                }
            }
        }
        return s.substring(start, end);
    }
    public boolean isPalindrome(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
    public static void main(String[] args){
        String input = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        Solution sol = new Solution();
        System.out.println(sol.longestPalindrome(input));
    }
}
