import java.util.Arrays;
public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null) return t == null;
        if(t == null || s.length() != t.length()) return false;

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);

        for(int i = 0; i < sArr.length; i++) {
            if(sArr[i] != tArr[i]) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "cat", t = "tcc";
        System.out.println(sol.isAnagram(s, t));
    }
}
