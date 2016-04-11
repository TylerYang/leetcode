import java.util.Stack;
public class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;

        Stack<Integer> stack = new Stack<Integer>();
        int i = 0, max = 0;
        int[] h = Arrays.copyOf(heights, heights.length + 1);
        while (i < h.length) {
            if (stack.empty() == true || h[stack.peek()] < h[i]) {
                stack.push(i);
            } else {
                max = Math.max(max, h[stack.pop()] * (stack.empty() == true ? i : i - stack.peek() - 1));
            }
        }
        return max;
    }
}
