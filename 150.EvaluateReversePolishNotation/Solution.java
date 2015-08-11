public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < tokens.length; i++) {
            if(isSign(tokens[i])) {
                int num2 = stack.pop(), num1 = stack.pop();
                stack.push(cal(num1, tokens[i], num2));
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
    private int cal(int n1, String sign, int n2) {
        int result = 0;
        switch(sign.charAt(0)) {
            case '+':
                result = n1 + n2;
                break;
            case '-':
                result = n1 - n2;
                break;
            case '*':
                result = n1 * n2;
                break;
            default:
                result = n1 / n2;
                break;
        }
        return result;
    }
    private boolean isSign(String sign) {
        return sign.length() == 1 && (sign.charAt(0) == '+' || sign.charAt(0) == '-' || sign.charAt(0) == '*' || sign.charAt(0) == '/');
    }
}