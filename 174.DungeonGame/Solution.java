public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon.length == 0) return 0;
        int[][] dp = new int[dungeon.length][dungeon[0].length];

        int m = dungeon.length, n = dungeon[0].length;

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                if(i == m - 1 && j == n - 1) {
                    dp[i][j] = Math.max(1 - dungeon[i][j], 1);
                    continue;
                }
                if(i == m - 1) {
                    dp[i][j] = Math.max(dp[i][j + 1] - dungeon[i][j], 1);
                } else if(j == n - 1) {
                    dp[i][j] = Math.max(dp[i + 1][j] - dungeon[i][j], 1); 
                } else {
                    int prevMin = Math.min(dp[i + 1][j], dp[i][j + 1]);
                    
                    dp[i][j] = Math.max(prevMin - dungeon[i][j], 1); 
                }
            }
        }

        return dp[0][0];


    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] dungeon = {
            {1, -3, 3},
            {0, -2, 0},
            {-2, -3, -3}
        };
        System.out.println(sol.calculateMinimumHP(dungeon));



    }
}
