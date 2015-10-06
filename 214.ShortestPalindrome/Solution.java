public class Solution {
     public String shortestPalindrome(String s) {
        if(s == null || s.length() == 0) return s;
        StringBuffer sBuff = new StringBuffer(s);

        String str = s + sBuff.reverse().toString();
    
        int[] next = genNext(str);
    
        int l = next[next.length - 1] + 1;
		
		if(l == str.length() - 1 || l == s.length()) {
			return s;
		}

		if(l > s.length()) {
			l++;
		}
		l %= s.length();
    	
        return new StringBuffer(s.substring(l)).reverse().toString() + s; 
    }
    

    private int[] genNext(String pattern) {
        int[] next = new int[pattern.length()];
        next[0] = -1;
        for(int i = 1; i < pattern.length(); i++) {
            int index = next[i - 1];
            while(index >= 0 && pattern.charAt(index + 1) != pattern.charAt(i)) {
                index = next[index];
            }
            if(pattern.charAt(index + 1) == pattern.charAt(i)) {
                next[i] = index + 1;
            } else {
                next[i] = -1;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
		
        String s = "ba";
		System.out.println(s + ":");
        System.out.println(sol.shortestPalindrome(s));
		
        s = "aabba";
		System.out.println(s + ":");
        System.out.println(sol.shortestPalindrome(s));
		
        s = "aba";
		System.out.println(s + ":");
        System.out.println(sol.shortestPalindrome(s));
		
		
    }
}
