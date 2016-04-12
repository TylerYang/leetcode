import java.util.Arrays;
import java.util.Stack;

public class Solution2 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int[] h = new int[matrix[0].length + 1];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int val = (int)matrix[i][j] - (int)'0';
                if (val == 0) {
                    h[j] = 0;
                } else {
                    h[j] += val;
                }
            }
            max = Math.max(calMaxRectangle(h), max);
        }
        return max;
    }
    public int calMaxRectangle(int[] h) {
        int i = 0, max = h[0];
        Stack<Integer> stack = new Stack<Integer>();

        while (i < h.length) {
            if (stack.empty() == true || h[stack.peek()] < h[i]) {
                stack.push(i++);
            } else {
                max = Math.max(max, h[stack.pop()] * (stack.empty() == true ? i : (i - stack.peek() - 1)));
            }
        }
        return max;
    }
}
