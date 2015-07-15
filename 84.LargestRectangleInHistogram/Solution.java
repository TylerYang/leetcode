import java.util.Stack;
public class Solution {
    public int largestRectangleArea(int[] height) {
        Stack<Integer> pStack = new Stack<Integer>();
        int i = 0, sum = 0;
        while(i < height.length) {
            if(pStack.empty() == true || height[i] > height[pStack.peek()]) {
                pStack.push(i++);
            } else {
                int j = pStack.pop();
                int h = height[j];
                int w = pStack.empty() ? i : i - pStack.peek() - 1;
                sum = Math.max(sum, w * h);
            }
        }
        while(pStack.empty() == false) {
            int j = pStack.pop();
            int h = height[j];
            int w = pStack.empty() ? i : i - pStack.peek() - 1;
            sum = Math.max(sum, w * h);
        }
        return sum;
    }
}
