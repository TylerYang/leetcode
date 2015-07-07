import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
public class Solution {
    private int[] cols;
    private int[] rd;
    private int[] ld;
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> rList = new ArrayList<List<String>>();
        if(n != 1 && n <= 3) return rList;
        cols = new int[n];
        rd = new int[2 * n - 1];
        ld = new int[2 * n - 1];
        char[][] cs = new char[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                cs[i][j] = '.';
            }
        }
        Stack<Integer> cStack = new Stack<Integer>();
        int initJ = -1;
       
        for(int i = 0; i < n; i++) {
            for(int j = initJ + 1; j < n; j++) {
                if(isValid(i, j, n)) {
                    cs[i][j] = 'Q';
                    if(i == n - 1) {
                        rList.add(genList(cs));
                        cs[i][j] = '.';
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
            if(cStack.empty()) {
                break;
            } else {
                initJ = cStack.pop();
                i--;
                cols[initJ] = 0;
                ld[initJ - i + n - 1] = 0;
                rd[i + initJ] = 0;
                cs[i][initJ] = '.';
            }
        } 
         
        return rList; 
    }
    private boolean isValid(int i, int j, int n) {
        return cols[j] == 0 && ld[j - i + n - 1] == 0 && rd[i + j] == 0; 
    }
    private List<String> genList(char[][] cs) {
        List<String> sList = new ArrayList<String>();
        for(int i = 0; i < cs.length; i++) {
            sList.add(new String(cs[i]));
        }
        return sList;
    }
}
