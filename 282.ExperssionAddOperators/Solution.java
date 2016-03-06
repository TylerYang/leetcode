import java.util.List;
import java.util.ArrayList;
public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> list = new ArrayList<String>();
        if(num == null || num.length() == 0) return list;
        helper(list, "", num, target, 0, 0, 0);
        return list;
    }
    private void helper(List<String> list, String expr, String num, int target, int pos, long evalVal, long lastVal) {
        if(pos == num.length()) {
            if(evalVal == target) list.add(expr);
            return;
        }
        for(int i = pos; i < num.length(); i++) {
            if(i != pos && num.charAt(pos) == '0') break;
            String subNum = num.substring(pos, i + 1);
            Long currVal = Long.parseLong(subNum);
            if(pos == 0) {
                helper(list, subNum, num, target, i + 1, currVal, currVal);
            } else {
                helper(list, expr + "+" + subNum, num, target, i + 1, evalVal + currVal, currVal);
                helper(list, expr + "-" + subNum, num, target, i + 1, evalVal - currVal, -currVal);
                helper(list, expr + "*" + subNum, num, target, i + 1, evalVal - lastVal + lastVal * currVal, lastVal * currVal);
            }
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        String num = "3456237490";
        int target = 9191;
        System.out.println(sol.addOperators(num, target));
    }
}
