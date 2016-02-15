import java.util.Stack;
public class Solution {
  public String removeDuplicateLetters(String s) {
    if(s.length() <= 1) return s;
    int[] cArr = countCharacters(s);
    boolean[] cMap = new boolean[26];
    Stack<Character> stack = new Stack<Character>();
    for(int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      int cOff = getOffset(c);
      if(cMap[cOff] == true){
        cArr[cOff]--;
        continue;
      }
      while(stack.empty() == false) {
        char peekC = stack.peek();
        int peekOff = getOffset(peekC);
        if(cArr[peekOff] == 0) break;
        if(peekOff < cOff) break;
        stack.pop();
        cMap[peekOff] = false;
      }
      stack.push(c);
      cMap[cOff] = true;
      cArr[cOff]--;
    }
    char[] sArr = new char[stack.size()];
    int j = sArr.length - 1;
    while(stack.empty() == false) {
      sArr[j--] = stack.pop();
    }
    return String.valueOf(sArr);
  }
  private int[] countCharacters(String s) {
    int[] cArr = new int[26];
    for(int i = 0; i < s.length(); i++) {
      int offset = getOffset(s.charAt(i));
      cArr[offset]++;
    }
    return cArr;
  }
  private int getOffset(char c) {
    return (int) c - 97;
  }
  public static void main(String[] args) {
    Solution sol = new Solution();
    // String s = "bcabc";
    //String s = "bbccaa";
    //String s = "cbacdcbc";
    System.out.println(sol.removeDuplicateLetters(s));
  }
}
