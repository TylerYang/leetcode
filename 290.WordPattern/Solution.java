import java.util.Set;
import java.util.HashSet;
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        if(pattern == null) return str == null;
        if(str == null) return false;
        String[] map = new String[26];
        Set<String> set = new HashSet<String>();
        int i = 0, count = 0;
        while(i < str.length() && count < pattern.length()) {
            int j = i;
            for(; j < str.length() && str.charAt(j) != ' '; j++) {}
            String val = str.substring(i, j);
            char key = pattern.charAt(count);
            int keyVal = (int)key - (int)'a';
            if(map[keyVal] == null) {
                if(set.contains(val) == true) return false;
                map[keyVal] = val;
            } else {
                if(map[keyVal].equals(val) == false) return false;
            }
            set.add(val);
            i = j + 1;
            count++;
        }
        if(i < str.length() || count < pattern.length()) return false;
        return true;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        String pattern = "abba";
        String str = "dog cat cat dog";
        System.out.println(sol.wordPattern(pattern, str));
    }
}
