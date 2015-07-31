import java.util.*;
public class Solution {
    public void solve(char[][] board) {
        if(board.length <= 2) return;
        
        char[][] cArr = new char[board.length][board[0].length];
        
        for(int i = 0; i < cArr.length; i++) {
            for(int j = 0; j < cArr[0].length; j++) {
                cArr[i][j] = board[i][j];
                board[i][j] = 'X';
            }
        }

        for(int i = 0; i < board.length; i++) {
            draw(i, 0, cArr, board);
            draw(i, board[0].length - 1, cArr, board);
        }
        for(int j = 0; j < board[0].length; j++) {
            draw(0, j, cArr, board);
            draw(board.length - 1, j, cArr, board);
        }

        return;
    }
    private void draw(int i, int j, char[][] cArr, char[][] board){ 
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(i * cArr[0].length + j);
        while(queue.isEmpty() == false) {
            int pos = queue.poll();
            int x = pos / cArr[0].length;
            int y = pos % cArr[0].length;
            if(cArr[x][y] == 'O' && board[x][y] != 'O') {
                board[x][y] = 'O';
                if(x > 0) queue.add((x - 1) * cArr[0].length + y);
                if(x < cArr.length - 1) queue.add((x + 1) * cArr[0].length + y);
                if(y > 0) queue.add(pos - 1);
                if(y < cArr[0].length) queue.add(pos + 1); 
            }
        }
        return;
    }
}
