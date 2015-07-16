public class Solution {
	public boolean isScramble(String s1, String s2) {
        if(s1.equals(s2)) return true;
        int size = s1.length();
        int v1 = 0, v2 = 0;
        for(int i = 0; i < size; i++) {
            v1 += s1.charAt(i) - 'a';
            v2 += s2.charAt(i) - 'a';
        }
        if(v1 != v2) return false;
        for(int i = 1; i < size; i++) {
            if(isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) return true;
            if(isScramble(s1.substring(0, i), s2.substring(size - i)) && isScramble(s1.substring(i), s2.substring(0, size - i))) return true;
        }
        return false;
    }
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.isScramble("aaccd","acaad"));
	}
}
