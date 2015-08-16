public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if(m == 0) return 0;
        if(m == n) return n;
        m = Math.max(n >> 1, m);
        int i = m + 1;
        while(i <= n && i > 0) {
            if(m == 0) return 0;
            m &= i++;
        }
        return m;
    }
}