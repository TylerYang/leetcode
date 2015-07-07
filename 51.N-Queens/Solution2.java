import java.util.List;
import java.util.ArrayList;
public class Solution2 {
    private int[] cols;
    private int[] rd;
    private int[] ld;
    char[][] cs;
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> rList = new ArrayList<List<String>>();
        if(n != 1 && n <= 3) return rList;
        cols = new int[n];
        rd = new int[2 * n + 1];
        ld = new int[2 * n + 1];
        cs = new char[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                cs[i][j] = '.';
            }
        }     
        sNQueens(n, 0, rList);
        return rList;
    }
    private void sNQueens(int n, int i, List<List<String>> rList) {
        for(int j = 0; j < n; j++) {
            if(isValid(i, j, n)) {
                cs[i][j] = 'Q';
                if(i == n - 1) {
                    rList.add(genList(cs)); 
                } else {
                    cols[i] = 1;
                    rd[i + j] = 1;
                    ld[j - i + n - 1] = 1;
                    
                    sNQueens(n, i + 1, rList);
                    
                    cols[i] = 0;
                    rd[i + j] = 0;
                    ld[j - i + n - 1] = 0;
                }
                cs[i][j] = '.';
            }
        }
        return;
    }

    private boolean isValid(int i, int j, int n) {
        return cols[j] == 0 && rd[i + j] == 0 && ld[j - i + n - 1] == 0;
    }
    
    private List<String> genList(char[][] cs) {
        List<String> sList = new ArrayList<String>();
        for(int i = 0; i < cs.length; i++){
            sList.add(new String(cs[i]));   
        }
        return sList;
    }
}
