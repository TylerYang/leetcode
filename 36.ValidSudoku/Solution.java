public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[board.length];
        int[] cols = new int[board[0].length];
        int[] sub = new int[board.length];
        
        for(int i = 0; i < board.length; i++ ){
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] != '.') {
                    int n = board[i][j] - '0';
                    int k = i/3*3 + j/3; 

                    if(getBit(rows[i], n)) return false;
                    if(getBit(cols[j], n)) return false;
                    if(getBit(sub[k], n)) return false;

                    rows[i] = setBit(rows[i], n);
                    cols[j] = setBit(cols[j], n);
                    sub[k] = setBit(sub[k], n);
                }
            }
        }
        return true;
    }

    private boolean getBit(int num, int i) {
        return (num >>> i & 0x01) == 1;
    }

    private int setBit(int num, int i) {
        return num | (0x01 << i); 
    }
}
