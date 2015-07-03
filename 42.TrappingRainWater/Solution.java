import java.util.Stack;
public class Solution {
    public int trap(int[] height) {
        if(height.length <= 2) return 0;
        int water = 0, len = height.length;
        
        Stack<Integer> pStack = new Stack<Integer>();
        if(height[0] > height[1]) pStack.push(0);

        for(int i = 1; i < len; i++) {
            int h = height[i];
            if(h >= height[i - 1] && (i == len - 1 || height[i + 1] < h)) {
                while(pStack.size() > 1) {
                    int prevP = pStack.pop();
                    if(height[prevP] > height[pStack.peek()] || height[prevP] > h) {
                        pStack.push(prevP);
                        break;
                    }
                }
                pStack.push(i);
            }
        }


        if(pStack.empty() == true) return 0;
        int p = pStack.pop();
        while(pStack.empty() == false) {
            int nextP = pStack.pop();
            water += calTrapWater(height, nextP, p);
            p = nextP;
        }

        return water;
    }
    private int calTrapWater(int[] height, int L, int R) {
        int c = 0, h = height[L] < height[R] ? height[L] : height[R];
        for(int i = L + 1; i < R; i++) {
            int tmp = h - height[i];
            if(tmp > 0) c += tmp;
        }

        return c;
    }
}

