import java.util.HashMap;
public class Solution {
    private static HashMap<Character, Integer> romanMap = new HashMap<Character, Integer>();
    static {
        romanMap.put('M', 1000); 
        romanMap.put('D', 500); 
        romanMap.put('C', 100); 
        romanMap.put('L', 50); 
        romanMap.put('X', 10); 
        romanMap.put('V', 5); 
        romanMap.put('I', 1); 
    }
    
    public int romanToInt(String s) {
        if(s.length() == 0) return 0;
        int r = 0;
        for(int i = 0; i < s.length(); i++) {
            int n = romanMap.get(s.charAt(i));    
            int tmp = r % n;
            if(tmp > 0) r -= tmp*2;
            r += n;
        }
        return r;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.romanToInt("IVXD"));
    }
}
