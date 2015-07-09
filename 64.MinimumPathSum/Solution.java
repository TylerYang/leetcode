public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        
        if(grid.length == 1 || grid[0].length == 1) {
            int r = 0;
            for(int i = 0; i < grid.length; i++) {
                for(int j = 0; j < grid[0].length; j++) {
                    r += grid[i][j];  
                }
            }
            return r;
        }
        int[][] sum = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                int m = i > 0 ? sum[i - 1][j] : Integer.MAX_VALUE;
                int n = j > 0 ? sum[i][j - 1] : Integer.MAX_VALUE;
                if(i == 0 && j == 0) m = 0;
                sum[i][j] = grid[i][j] + Math.min(m, n);
            }
        }
        return sum[grid.length - 1][grid[0].length - 1];
    }
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[][] grid = {
			{1, 2},
			{1, 1}
		};
		System.out.println(sol.minPathSum(grid));
	}
}