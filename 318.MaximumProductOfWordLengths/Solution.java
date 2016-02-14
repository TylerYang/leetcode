public class Solution {
  public int maxProduct(String[] words) {
    int[] wordMaps = new int[words.length];

    for(int i = 0; i < words.length; i++) {
      wordMaps[i] = genMapFromWord(words[i]);
    }
    int maxPro = 0;
    for(int i = 0; i < words.length; i++) {
      for(int j = 0; j < words.length; j++) {
        int len = words[i].length() * words[j].length();
        if((wordMaps[i] & wordMaps[j]) == 0 && len > maxPro) {
          maxPro = len;
        }
      }
    }
    return maxPro;
  }
  private int genMapFromWord(String s) {
    int mapNum = 0;
    for(int i = 0; i < s.length(); i++) {
      int c = (int)s.charAt(i) - (int)'a';
      mapNum = setBit(mapNum, c);
    }
    return mapNum;
  }
  private int setBit(int num, int pos) {
    return num | (1 << pos);
  }
  public static void main(String[] args) {
    Solution sol = new Solution();
    // String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
    String[] words = {"a", "aa", "aaa", "aaaa"};
    //String[] words = {"a", "ab", "abc", "d", "cd", "bcd", "abcd"};
    System.out.println(sol.maxProduct(words));
  }
}
