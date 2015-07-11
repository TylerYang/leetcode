public class Solution {
    public int mySqrt(int x) {
        if(x == 0) return 0;
        if(x <= 3) return 1;
        int r = 2;
        while(r * r < x && r * r > 0) {
            r *= 2;
        }

        if(r * r == x) return r;
        int L = r/2, R = r;
        while(L < R - 1) {
            int M = (L + R) / 2;
            int tmp = M * M;
            if(tmp == x) {
                return M;
            } else if(tmp < 0 || tmp > x) {
                R = M - 1;
            } else {
                L = M;
            }
        }
        if(R * R <= x) return R;
        return L;
    }
}
