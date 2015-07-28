import java.util.*;
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] sum = new int[triangle.size()];
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < triangle.size(); i++) {
            List<Integer> curr = triangle.get(i);
            for(int j = curr.size() - 1; j >= 0; j--) {
                if(j == 0) {
                    sum[j] = curr.get(j);
                } else if(j == curr.size() - 1) {
                    sum[j] = curr.get(j) + sum[j - 1];
                } else {
                    sum[j] = curr.get(j) + Math.min(sum[j], sum[j - 1]);
                }
                if(sum[j] < min) min = sum[j];
            }
        }
        return min;
    }
}
