import java.util.Stack;
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int[] height = new int[matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    if (i > 0 && matrix[i][j] == matrix[i - 1][j]) {
                        height[i] += 1;
                    } else {
                        height[i] = 1;
                    }
                } else {
                    height[j] = 0;
                }
            }
            int r = calMaxRectangle(height);
            if (r > max) max = r;
        }
        return max;
    }
    private int calMaxRectangle(int[] height) {
        Stack<Integer> ps = new Stack<Integer>();
        int i = 0, sum = 0;
        while(i < height.length) {
            if(ps.empty() || height[ps.peek()] < height[i]) {
                ps.push(i++);
            } else {
                int j = ps.pop();
                int h = height[j];
                int w = ps.empty() ? i : i - ps.peek() - 1;
                sum = Math.max(sum, w * h);
            } 
        }
        while(ps.empty() == false) {
            int j = ps.pop();
            int h = height[j];
            int w = ps.empty() ? i : i - ps.peek() - 1;
            sum = Math.max(sum, w * h);
        }
            
        return sum;
    }
}
