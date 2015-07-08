import java.util.List;
import java.util.ArrayList;
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> rList = new ArrayList<Integer>();
        if(matrix.length == 0 || matrix[0].length == 0) return rList;
        if(matrix.length == 1 || matrix[0].length == 1) {
            for(int i = 0; i < matrix.length; i++) {
                for(int j = 0; j < matrix[0].length; j++) {
                    rList.add(matrix[i][j]); 
                }
            }
            return rList;
        }
        
        int w = matrix[0].length, h = matrix.length;
        int len = (w + h) * 2 - 4, x = 0, y = 0;
        int xOff = 0, yOff = 1;
        int[] cArr = new int[4];
        while(len > 0 && w > 0 && h > 0) {
            cArr[0] = w;
            cArr[1] = w + h - 1;
            cArr[2] = 2 * w + h - 2;
            cArr[3] = len;
                
            for(int i = 1; i <= len; i++) {
                if(i == cArr[0]) {
                    x = 1;
                    y = 0; 
                } else if(i == cArr[1]) {
                    x = 0;
                    y = -1;
                } else if(i == cArr[2]) {
                    x = -1;
                    y = 0;
                } else if(i == cArr[3]) {
                    x = 0;
                    y = 1;
                } 
                rList.add(matrix[x][y]);
                x += xOff;
                y += yOff;
            }
            len -= 8;
            w -= 2;
            h -= 2;
        }        
        if(rList.size() < matrix.length * matrix[0].length) rList.add(matrix[matrix.length/2][matrix.length/2]);
        
        return rList;
    }
}
