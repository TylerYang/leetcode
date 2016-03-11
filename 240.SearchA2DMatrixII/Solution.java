import java.util.Arrays;
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        return searchMatrixIn(matrix, target, 0, 0, matrix.length - 1, matrix[0].length - 1);
    }
    private boolean searchMatrixIn(int[][] matrix, int target, int x1, int y1, int x2, int y2) {
        if (x1 == x2 ){
            if(y1 == y2) return matrix[x1][y1] == target;
            return Arrays.binarySearch(matrix[x1], y1, y2 + 1, target) >= 0;
        }

        int midX = x1 + (x2 - x1) / 2;
        int midY = y1 + (y2 - y1) / 2;
        if (matrix[midX][midY] == target) return true;

        if(midX == x1 && midY == y1)
            return (y1 + 1 < matrix[0].length && matrix[x1][y1 + 1] == target) ||
                   (x1 + 1 < matrix.length && matrix[x1 + 1][y1] == target) ||
                   matrix[x2][y2] == target;

        if (matrix[midX][midY] < target) {
            //search in right bottom corner
            if (searchMatrixIn(matrix, target, midX, midY, x2, y2))
                return true;
        } else {
            //search in left top corner
            if (searchMatrixIn(matrix, target, x1, y1, midX, midY))
                return true;
        }

        //search in top right corner
        if (midY + 1 <= y2 && midX - 1 >= x1 &&
                searchMatrixIn(matrix, target, x1, midY + 1, midX - 1, y2))
            return true;

        //search in left bottom corner
        if (midX + 1 <= x2 && midY - 1 >= y1 &&
                searchMatrixIn(matrix, target, midX + 1, y1, x2, midY - 1))
            return true;

        return false;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] matrix = {
            {-1},
            {-1}
        };

        System.out.println(sol.searchMatrix(matrix, -2));

    }
}
