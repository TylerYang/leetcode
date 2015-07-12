
public class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return;
        boolean fr = false, fc = false;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    if(j == 0) {
                        fc = true;
                    } else {
                        matrix[0][j] = 0;    
                    }
                    if(i == 0) {
                        fr = true;
                    } else {
                        matrix[i][0] = 0;
                    }
                }   
            }
        }
        
        for(int i = 1; i < matrix.length; i++) {
            if(matrix[i][0] == 0) paintRow(matrix, i);
        }
        for(int i = 1; i < matrix[0].length; i++) {
            if(matrix[0][i] == 0) paintCol(matrix, i);
        }
        if(fr == true) paintRow(matrix, 0);
        if(fc == true) paintCol(matrix, 0);
        return;
    }
    private void paintRow(int[][] matrix, int r) {
        for(int i = 0; i < matrix[0].length; i++) {
            matrix[r][i] = 0;
        }
        return;
    }
    private void paintCol(int[][] matrix, int c) {
        for(int i = 0; i < matrix.length; i++) {
            matrix[i][c] = 0;
        }
        return;
    }
}