import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
public class Solution {
    //1. convert to postfix expression
    //2. cal the postfix expression
    public int calculate(String s) {
        Stack<Character> stack = new Stack<Character>();
        Stack<Integer> numStack = new Stack<Integer>();
        List<String> list = new ArrayList<String>();
        int i = 0;
        //String s = "2 + 3 *  5 * 5";
        while(i < s.length()) {
            while(i < s.length() && s.charAt(i) == ' ') i++;
            if(i == s.length()) break;

            char c = s.charAt(i);
            if(isOpt(c)) {
                while(stack.empty() == false && isLarger(stack.peek(), c)) {
                    Character prevOpt = stack.pop();
                    list.add(prevOpt.toString());
                }
                stack.push(c);
                i++;
            } else {
                int j = i;
                while(j < s.length() && s.charAt(j) != ' ' &&
                        isOpt(s.charAt(j)) == false) {
                    j++;
                }
                list.add(s.substring(i, j));
                i = j;
            }
        }
        while(stack.empty() == false){
            Character prevOpt = stack.pop();
            list.add(prevOpt.toString());
        }
        for(int j = 0; j < list.size(); j++) {
            String n = list.get(j);
            if(isNum(n)) {
                numStack.push(Integer.parseInt(n));
            } else {
                int num2 = numStack.pop();
                int result = cal(numStack.pop(), n.charAt(0), num2);
                numStack.push(result);
            }
        }
        return numStack.pop();
    }
    private int cal(int num1, char opt, int num2) {
        if(opt == '+') {
            return num1 + num2;
        } else if(opt == '-') {
            return num1 - num2;
        } else if(opt == '*') {
            return num1 * num2;
        } else {
            return num1 / num2;
        }
    }
    private boolean isNum(String n) {
        return (int) n.charAt(0) >= (int)'0' && (int) n.charAt(0) <= (int)'9';
    }
    private boolean isLarger(char a, char b) {
        if(a == '*' || a == '/') return true;
        if(b == '+' || b == '-') return true;
        return false;
    }
    private boolean isOpt(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "1-1+1";
        System.out.println(sol.calculate(s));
    }
}
