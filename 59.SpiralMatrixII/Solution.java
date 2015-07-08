public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] m = new int[n][n];
        if(n == 0) return m;
        
        int len = 4 * n - 4, w = n, x = 0, y = 0, xOff = 0, yOff = 1, num = 1;
        int[] c = new int[4];
        while(len > 0) {
            c[0] = w;
            c[1] = 2 * w - 1;
            c[1] = 3 * w - 2;
            c[3] = len;

            for(int i = 1; i <= len; i++) {
                if(i == c[0]) {
                    xOff = 1;
                    yOff = 0;
                } else if(i == c[1]) {
                    xOff = 0;
                    yOff = -1;
                } else if(i == c[2]) {
                    xOff = -1;
                    yOff = 0;
                } else if(i == c[3]) {
                    xOff = 0;
                    yOff = 1;
                }
                m[x][y] = num++;
                x += xOff;
                y += yOff;
            }
            len -= 8;
            w -= 2;
        }
        if(n % 2 == 1) m[n/2][n/2] = num;

        return m;
    }
}
