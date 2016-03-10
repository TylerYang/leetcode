import java.util.List;
import java.util.ArrayList;
public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> numList = new ArrayList<Integer>();
        List<Character> optList = new ArrayList<Character>();
        int i = 0;
        while(i < input.length()) {
            int j = i;
            while(j < input.length() && isOpt(input.charAt(j)) == false) {
                j++;
            }
            numList.add(Integer.parseInt(input.substring(i, j)));
            if(j < input.length()) {
                optList.add(input.charAt(j));
            }
            i = j + 1;
        }
        return diffWays(numList, optList, 0, numList.size() - 1);
    }
    public List<Integer> diffWays(List<Integer> numList, List<Character> optList, int start, int end) {
        List<Integer> list = new ArrayList<Integer>();
        if(numList.size() == 0) return list;
        if(end == start) {
            list.add(numList.get(start));
            return list;
        }
        for(int i = start; i < end; i++) {
            List<Integer> leftSubList = diffWays(numList, optList, start, i);
            List<Integer> rightSubList = diffWays(numList, optList, i + 1, end);

            char opt = optList.get(i);
            for(int j = 0; j < leftSubList.size(); j++) {
                for(int k = 0; k < rightSubList.size(); k++) {
                    int result = cal(leftSubList.get(j), opt, rightSubList.get(k));
                    list.add(result);
                }
            }
        }
        return list;
    }
    private int cal(int num1, char opt, int num2) {
        if(opt == '*')  return num1 * num2;
        if(opt == '+') return num1 + num2;
        if(opt == '-') return num1 - num2;

        throw new IllegalArgumentException();
    }
    private boolean isOpt(char c) {
        return c == '+' || c == '*' || c == '-';
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        //String input = "2*3-4*5";
        String input = "";
        System.out.println(sol.diffWaysToCompute(input));
    }
}
