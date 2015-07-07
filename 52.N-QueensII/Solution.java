import java.util.Stack;
public class Solution { 
    private int[] cols;
    private int[] ld;
    private int[] rd;
    
    public int totalNQueens(int n) {
        if(n != 1 && n <= 3) return 0;
        cols = new int[n];
        ld = new int[2 * n - 1];
        rd = new int[2 * n - 1];
        
        Stack<Integer> cStack = new Stack<Integer>();
        int count = 0, initJ = -1;
        for(int i = 0; i < n; ) {
            for(int j = initJ + 1; j < n; j++) {
                if(isValid(i, j, n)) {
                    if(i == n - 1) {
                        count++;
                    } else {
                        cols[j] = 1;
                        ld[j - i + n - 1] = 1;
                        rd[i + j] = 1;
                        cStack.push(j);
                        j = -1;
                        i++;
                    }
                }
            }
            if(cStack.empty() == true) {
                break;
            } else {
                initJ = cStack.pop();
                i--;
                cols[initJ] = 0;
                ld[initJ - i + n - 1] = 0;
                rd[i + initJ] = 0; 
            }
        }

        return count;
    }
    private boolean isValid(int i, int j, int n) {
        return cols[j] == 0 && ld[j - i + n - 1] == 0 && rd[i + j] == 0;
    }
}
