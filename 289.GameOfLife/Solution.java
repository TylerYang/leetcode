public class Solution {
    private final static int[] dirX = {-1, -1, 1, 1, 0, 0, 1, -1};
    private final static int[] dirY = {-1,  1, 1,-1, 1,-1, 0,  0};
    public void gameOfLife(int[][] board) {
        if(board.length == 0 || board[0].length == 0) return;
        int n = board.length, m = board[0].length;
        boolean[][] map = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                map[i][j] = getNextState(board, i, j);
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                board[i][j] = map[i][j] == true ? 1 : 0;
            }
        }
    }
    private boolean getNextState(int[][] board, int x, int y) {
        int count = 0;
        for(int i = 0; i < dirX.length; i++){
            int neighX = x + dirX[i];
            int neighY = y + dirY[i];
            if(neighX >= 0 && neighX < board.length && neighY >= 0 && neighY < board[0].length) {
                if(board[neighX][neighY] == 1) count++;
            }
        }
        //Dead cell with exactly 3 live neighbors
        if(board[x][y] == 0) {
            return count == 3;
        } else {
            if(count < 2) {
                //Live cell with fewer than 2 live neighbors => dies
                return false;
            } else if(count > 3) {
                //Live cell with more than 3 live neighbors => dies
                return false;
            } else {
                //Live cell with 2 or 3 live neighborsa => live
                return true;
            }
        }
    }
    public static void printArray(int[][] board) {
        int n = board.length, m = board[0].length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] board = {
            {1, 0, 1, 0, 1},
            {1, 1, 0, 1, 0},
            {1, 1, 1, 0, 0}
        };
        printArray(board);
        sol.gameOfLife(board);
        printArray(board);
    }
}
