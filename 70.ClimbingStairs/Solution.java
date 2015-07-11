public class Solution {
    public int climbStairs(int n) {
        if(n <= 2) return n;
        int[] step = {1, 2};
        int i = 0, j = 3;
        while(j < n) {
            step[i++ % 2] = step[0] + step[1];
            j++;
        }
        return step[0] + step[1];
    }
}
