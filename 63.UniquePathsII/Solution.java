public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length == 0 || obstacleGrid[0].length == 0 || obstacleGrid[0][0] == 1) return 0;
        int x = obstacleGrid.length, y = obstacleGrid[0].length;

        int[][] path = new int[x][y];
        path[0][0] = 1;
        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++) {
                if(obstacleGrid[i][j] == 1) {
                    path[i][j] = 0;
                } else {
                    int m = i > 0 ? path[i - 1][j] : 0;
                    int n = j > 0 ? path[i][j - 1] : 0;
                    path[i][j] += m + n;
                }
            }
        }
        return path[x - 1][y - 1];
    }
	public static void main(String[] args) {
		int[][] input = new int[1][1];
		input[0][0] = 0;
		Solution sol = new Solution();
		System.out.println(sol.uniquePathsWithObstacles(input));
	}
}