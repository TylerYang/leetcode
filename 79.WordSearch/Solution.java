public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board.length == 0 || board[0].length == 0) return word.length() == 0;
        if(word.length() == 0) return true;
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(word.length() == 1) return true;
                    board[i][j] = '$';
                    
                    if(i > 0 && find(board, i - 1, j, word, 1)) return true;
                    if(j > 0 && find(board, i, j - 1, word, 1)) return true;
                    if(i < board.length - 1 && find(board, i + 1, j, word, 1)) return true;
                    if(j > board[0].length - 1 && find(board, i, j + 1, word, 1)) return true;
                    
                    board[i][j] = word.charAt(1);
                }
            }
        }
        return false;
    }
    private boolean find(char[][] board, int i, int j, String word, int k) {
        if(k == word.length()) return true;
        if(board[i][j] == '$' || board[i][j] != word.charAt(k)) return false;

        board[i][j] = '$';
        
        if(i > 0 && find(board, i - 1, j, word, k + 1)) return true;
        if(j > 0 && find(board, i, j - 1, word, k + 1)) return true;
        if(i < board.length - 1 && find(board, i + 1, j, word, k + 1)) return true;
        if(j > board[0].length - 1 && find(board, i, j + 1, word, k + 1)) return true;
        
        board[i][j] = word.charAt(k);
                    
        return false; 
    }
}
