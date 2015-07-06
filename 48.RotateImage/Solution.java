public class Solution {
    public void rotate(int[][] matrix) {
        if(matrix.length <= 1) return;
        int s = 0, e = matrix.length - 1, halfLen = matrix.length/2;
        
        while(s < halfLen) {
            int rotateNum = e - s;
            for(int i = 0; i < rotateNum; i++) {
                int tmp = matrix[s][s+i];
                matrix[s][s+i] = matrix[e-i][s];
                matrix[e-i][s] = matrix[e][e-i];
                matrix[e][e-i] = matrix[s+i][e];
                matrix[s+i][e] = tmp;    
            }
            s++;
            e--;
        }
        return;
    }
}
