public class NumMatrix3 {
    private int[][] dp;

    public NumMatrix3(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;

        dp = new int[matrix.length + 1][matrix[0].length + 1];
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (dp == null || dp.length == 0 || dp[0].length == 0) return 0;
        return dp[row2 + 1][col2 + 1] - dp[row2 + 1][col1] - dp[row1][col2 + 1] + dp[row1][col1];
    }
    public static void main(String[] args) {
        int[][] matrix = {
            {3, 0, 1, 4, 2},
            {5, 6, 3, 2, 1},
            {1, 2, 0, 1, 5},
            {4, 1, 0, 1, 7},
            {1, 0, 3, 0, 5}
        };
        NumMatrix3 numMatrix = new NumMatrix3(matrix);

        System.out.println(numMatrix.sumRegion(2, 1, 4, 3)); //8
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2)); //11
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4)); //12
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);
