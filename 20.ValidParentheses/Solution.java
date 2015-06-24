import java.util.Stack;
public class Solution{
    public boolean isValid(String s){
        Stack<Character> pStack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(isOpenChar(c)) {
                pStack.push(c);
            } else {
                if(pStack.size() == 0) return false;
                char oc = pStack.peek();
                if(isPair(oc, c)) {
                    pStack.pop();
                } else {
                    return false;
                }
            }
        }
        return pStack.size() == 0;
    }
    private boolean isOpenChar(char c){
        return c == '(' || c == '[' || c == '{';
    }
    private boolean isPair(char oc, char c){
        switch(oc) {
            case '(':
                return c == ')';
            case '[':
                return c == ']';
            default: 
                return c == '}';
        }
    }
}
