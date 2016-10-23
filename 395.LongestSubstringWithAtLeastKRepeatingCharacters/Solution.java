public class Solution {
    public int longestSubstring(String s, int k) {
        if (k == 1) {
            return s.length();
        }
        int result = 0;
        for (int i = 0; i < s.length() - k; i++) {
            int[] alphabets = new int[26];
            int mask = 0;
            int maxJ = 0;
            for (int j = i; j < s.length(); j++) {
                int offset = (int) s.charAt(j) - 97;
                alphabets[offset]++;
                if (alphabets[offset] < k) {
                    mask |= (1 << offset);
                } else {
                    mask &= ~(1 << offset);
                }
                if (mask == 0) {
                    result = Math.max(result, j - i + 1);
                    maxJ = j;
                }
            }
            i = maxJ;
        }
        return result;
    }
}
