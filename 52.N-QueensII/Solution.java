public class Solution { 
    private int[] cols;
    private int[] ld;
    private int[] rd;
    
    public int totalNQueens(int n) {
        if(n != 1 && n <= 3) return 0;
        cols = new int[n];
        ld = new int[2 * n - 1];
        rd = new int[2 * n - 1];
        
        return countNQueens(0, n); 
    }
    private int countNQueens(int i, int n) {
        int count = 0;
        for(int j = 0; j < n; j++) {
            if(isValid(i, j, n)) {
                if(i == n - 1) {
                    count++;
                } else {
                    cols[j] = 1;
                    ld[j - i + n - 1] = 1;
                    rd[i + j] = 1;
                    
                    count += countNQueens(i + 1, n);
                   
                    cols[j] = 0; 
                    ld[j - i + n - 1] = 0;
                    rd[i + j] = 0;
                }
            }
        }
        return count;
    }
    private boolean isValid(int i, int j, int n) {
        return cols[j] == 0 && ld[j - i + n - 1] == 0 && rd[i + j] == 0;
    }
}
