public class Solution {
    //two cases: with *, without *
    public boolean isMatch(String s, String p){
        if(p.length() == 0){
            if(s.length() == 0) return true;
            return false;
        }
        if(p.length() == 1){
            if(s.length() == 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')){
                return true;
            }
            return false;
        }
        
        if(p.charAt(1) != '*'){
            if(s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')){
                return isMatch(s.substring(1), p.substring(1)); 
            }
            return false;
        } else {
            String subP = p.substring(2);
            if(isMatch(s, subP)){
                return true;
            } else {
                char c = p.charAt(0);
                for(int i = 0; i < s.length() && (s.charAt(i) == c || c == '.'); i++){
                    if(isMatch(s.substring(i + 1), subP)) return true;
                }
                return false;
            }
    
        }
    }
    public static void main(String[] args){
        String s = "abcaa";
        String p = "a.*a";
        Solution sol = new Solution();
        System.out.println(sol.isMatch(s, p)); 
    }
}
