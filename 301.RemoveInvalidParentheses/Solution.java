import java.util.List;
import java.util.ArrayList;

public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> list = new ArrayList<String>();
        char[] paren = {'(', ')'};
        remove(s, 0, 0, list, paren);
        return list;
    }
    //   01234567
    //s: (a)())(), lastI: 0, lastJ: 0
    private void remove(String s, int lastI, int lastJ, List<String> list, char[] paren) {
        int count = 0;
        for(int i = lastI; i < s.length(); i++) {
            if(s.charAt(i) == paren[0]) count++; //count: -1
            if(s.charAt(i) == paren[1]) count--;

            if(count < 0) {
                //j: 0
                for(int j = lastJ; j <= i; j++) {
                    if(s.charAt(j) == paren[1] && (j == lastJ || s.charAt(j - 1) != paren[1]))
                        remove(s.substring(0, j) + s.substring(j + 1), i, j, list, paren);
                }
                return;
            }
        }
        String reversed = new StringBuffer(s).reverse().toString();
        if(paren[0] == '(') {
            char[] reParen = {')', '('};
            remove(reversed, 0, 0, list, reParen);
        } else {
            list.add(reversed);
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "(a)())()";
        System.out.println(sol.removeInvalidParentheses(s));
    }
}
