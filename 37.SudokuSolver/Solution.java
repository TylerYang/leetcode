public class Solution {
    private int[] rows = new int[9];
    private int[] cols = new int[9];
    private int[] subs = new int[9];
    private int[] missRows;
    private int[] missCols;
    public void solveSudoku(char[][] board) {
        int missLen = 0;
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++ ){
                if(board[i][j] != '.') {
                    int n = board[i][j] - '0';
                    int k = i / 3 * 3 + j / 3;
                    rows[i] = setBit(rows[i], n);
                    cols[j] = setBit(cols[j], n);
                    subs[k] = setBit(subs[k], n);
                } else {
                    missLen++;
                }
            }
        }
        

        if(missLen == 0) return;

        missRows = new int[missLen];
        missCols = new int[missLen];
        int k = 0;
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    missRows[k] = i;
                    missCols[k] = j;
                }        
            }
        }
        
        solSudoku(board, 0);

    }
    private boolean solSudoku(char[][] board, int idx) {
        if(idx == missRows.length) return true;
        int currI = missRows[idx], currJ = missCols[idx];
        int currK = currI / 3 * 3 + currJ / 3;
        for(int i = 1; i <= 9; i++) {
            if(!getBit(rows[currI], i) && !getBit(cols[currJ], 1) && !getBit(subs[currK], i)){
                rows[currI] = setBit(rows[currI], i);
                cols[currJ] = setBit(cols[currJ], i);
                subs[currK] = setBit(subs[currK], i);

                if(solSudoku(board, idx + 1)){
                    board[currI][currJ] = (char)('0' + i);
                    return true;
                }

                rows[currI] = clearBit(rows[currI], i);
                cols[currJ] = clearBit(cols[currJ], i);
                subs[currK] = clearBit(subs[currK], i);
            }
        }
        
        return false; 
    }
    private boolean getBit(int num, int i) {
        return (num >>> i & 0x01) == 1;     
    }
    private int setBit(int num, int i) {
        return num | (0x01 << i);
    }
    private int clearBit(int num, int i) {
        return ~(0x01<<i) & num;

    }
    
}
