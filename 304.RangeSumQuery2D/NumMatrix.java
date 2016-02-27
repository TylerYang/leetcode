public class NumMatrix {
    private int[][] sumMatrix;
    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int x = matrix.length, y = matrix[0].length;
        sumMatrix = new int[x][y];
        int sum = 0;
        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++) {
                sum += matrix[i][j];
                sumMatrix[i][j] = sum;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(sumMatrix == null || sumMatrix.length == 0 || sumMatrix[0].length == 0) return 0;
        int sum = 0;
        for(int i = row1; i <= row2; i++) {
            sum += sumMatrix[i][col2];

            if(i == 0 && col1 == 0) continue;

            if(col1 == 0) {
                sum -= sumMatrix[i - 1][sumMatrix[0].length - 1];
            } else {
                sum -= sumMatrix[i][col1 - 1];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {3, 0, 1, 4, 2},
            {5, 6, 3, 2, 1},
            {1, 2, 0, 1, 5},
            {4, 1, 0, 1, 7},
            {1, 0, 3, 0, 5}
        };
        matrix = {{0}};
        NumMatrix numMatrix = new NumMatrix(matrix);

        System.out.println(numMatrix.sumRegion(2, 1, 4, 3)); //8
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2)); //11
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4)); //12
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);
