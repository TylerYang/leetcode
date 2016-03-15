import java.util.Stack;
public class Solution {
    public int calculate(String s) {
        if(s.length() == 0) return 0;
        int i = 0, result = 0;
        char opt = '+';
        Stack<Integer> numStack = new Stack<Integer>();
        Stack<Character> optStack = new Stack<Character>();

        while(i < s.length()) {
            while(i < s.length() && s.charAt(i) == ' ') {
                i++;
            }
            if(i == s.length()) break;
            char c = s.charAt(i);
            if(c == '(') {
                numStack.push(result);
                optStack.push(opt);
                result = 0;
                opt = '+';
                i++;
            } else if(c == ')') {
                int num = numStack.pop();
                char tmpOpt = optStack.pop();
                if(tmpOpt == '+') {
                    result = num + result;
                } else {
                    result = num - result;
                }
                i++;
            } else if(isOpt(c)) {
                opt = c;
                i++;
            } else {
                int j = i;
                while(j < s.length() && s.charAt(j) != ' '
                        && isOpt(s.charAt(j)) == false
                        && isParen(s.charAt(j)) == false) {
                    j++;
                }
                int num = Integer.parseInt(s.substring(i, j));
                if(opt == '+') {
                    result += num;
                } else {
                    result -= num;
                }
                i = j;
            }
        }
        return result;
    }
    private boolean isParen(char c) {
        return c == '(' || c == ')';
    }
    private boolean isOpt(char c) {
        return c == '+' || c == '-';
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        String s = "1-(5)";
        System.out.println(sol.calculate(s));
    }
}
