public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for(int i = 0; i < 32; i++) {
            if(getBit(n, i)) count++;
        }
        return count;
    }
    private boolean getBit(int n, int i) {
        return ((n >> i) & 1) == 1;
    }
}