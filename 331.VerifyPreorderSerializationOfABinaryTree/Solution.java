import java.util.Stack;

public class Solution {
      public boolean isValidSerialization(String preorder) {
        if((preorder.length() == 1 && preorder.charAt(0) == '#') || preorder.length() == 0) return true;
        Stack<String> stack = new Stack<String>();
        int i = 0;
        int nullCount = 0;

        while(i < preorder.length()) { char c = preorder.charAt(i);
          if(nullCount > 0 && stack.empty() == true) return false;
          if(c == '#') {
            nullCount++;
            i++;
          } else {
            StringBuffer sBuff = new StringBuffer();
            while(i < preorder.length() && preorder.charAt(i) != ',') {
              sBuff.append(preorder.charAt(i++));
            }
            stack.push(sBuff.toString());
          }
          i++;
          if(nullCount > 0 && stack.empty() == true) return false;
          while(nullCount >= 2) {
            if(stack.empty() == true) return false;
            stack.pop();
            nullCount--;
          }
        }
        if(nullCount == 1 && stack.empty() == true) {
          return true;
        } else {
          return false;
        }
      }
}
