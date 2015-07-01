import java.util.Stack;
public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> pStack = new Stack<Integer>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ')' && pStack.empty() == false && s.charAt(pStack.peek()) == ')') {
                pStack.pop();
            } else {
                pStack.push(i);
            }    
        }
        
        int max = 0, curr = s.length();
        while(pStack.empty() == false) {
            int next = pStack.pop();
            int tmp = curr - next - 1;
            if(tmp > max) max = tmp;
            curr = next;
        }
        return max > curr ? max : curr;
    }
}
