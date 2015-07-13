public class Solution2 {
    //Divid and conquer
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        return  sMatrix(matrix, target, 0, 0, matrix.length - 1, matrix[0].length - 1);
    } 
    private boolean sMatrix(int[][] matrix, int target, int x1, int y1, int x2, int y2) {
        if(x1 == x2 && y1 == y2) return matrix[x1][y1] == target; 
        if(x1 == matrix.length || x2 == matrix.length || y1 == matrix[0].length || target < matrix[x1][y1] || target > matrix[x2][y2]) return false;
        int mx = (x1 + x2) / 2, my = (y1 + y2) / 2;
        if(matrix[mx][my] == target) return true;
        if(matrix[mx][my] > target) {
            return sMatrix(matrix, target, x1, y1, mx, my) || sMatrix(matrix, target, x1, my + 1, mx, y2) || sMatrix(matrix, target, mx + 1, y1, x2, my);
        } else {
            return sMatrix(matrix, target, mx + 1, my + 1, x2, y2) || sMatrix(matrix, target, x1, my + 1, mx, y2) || sMatrix(matrix, target, mx + 1, y1, x2, my);
        }
    }
    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        int[][] matrix = { 
            { 1 }, 
            { 3 }    
        };
        System.out.println(sol.searchMatrix(matrix, 2));
    }
}
