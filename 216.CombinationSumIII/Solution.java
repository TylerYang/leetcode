import java.util.*;
public class Solution {
    private final static int END_NUMBER = 9;
    public List<List<Integer>> combinationSum3(int k, int n) {
        return calCombinationStartWith(k, n, 1);
    }
    private List<List<Integer>> calCombinationStartWith(int k, int n, int start) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (k == 1) {
            if (n >= start && n <= END_NUMBER) {
                List<Integer> tmpList = new ArrayList<Integer>();
                tmpList.add(n);
                list.add(tmpList);
            }
            return list;
        }
        if(n - start <= start) return list;

        int end = END_NUMBER - k + 1;
        for(int m = start; m <= end; m++) {
            List<List<Integer>> subList = calCombinationStartWith(k - 1, n - m, m + 1);
            if (subList.size() > 0) {
                for (List<Integer> tmpList : subList) {
                    tmpList.add(0, m);
                    list.add(tmpList);
                }
            }
        }
        return list;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int k = 3, n = 7;
        System.out.println(sol.combinationSum3(k, n));
    }
}
