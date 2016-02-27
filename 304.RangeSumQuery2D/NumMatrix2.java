public class NumMatrix2 {
    private int[] sums;
    private int rows;
    private int cols;
    public NumMatrix2(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        rows = matrix.length;
        cols = matrix[0].length;
        int sum = 0;
        sums = new int[rows * cols + 1];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                sum += matrix[i][j];
                int offset = i * cols + j + 1;
                sums[offset] = sum;
            }
        }
    }

    private int sumRange(int n1, int n2) {
        return sums[n2] - sums[n1 - 1];
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int total = sumRange(row1 * cols + col1 + 1, row2 * cols + col2 + 1);
        for(int i = row1; i < row2; i++) {
            total -= sumRange(i * cols + col2 + 2, (i + 1) * cols + col1);
        }
        return total;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {3, 0, 1, 4, 2},
            {5, 6, 3, 2, 1},
            {1, 2, 0, 1, 5},
            {4, 1, 0, 1, 7},
            {1, 0, 3, 0, 5}
        };
        NumMatrix2 numMatrix = new NumMatrix2(matrix);

        System.out.println(numMatrix.sumRegion(2, 1, 4, 3)); //8
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2)); //11
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4)); //12
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);
