public class Solution {
    public int reverseBits(int n) {
        int r = 0;
        for(int i = 0; i < 32; i++){
            if(n == 0) {
                r <<= 1;
            } else {
                int m = n & 1;
                r = (r << 1) | m;
                n >>= 1;
            }
        }
        return r;
    }
}