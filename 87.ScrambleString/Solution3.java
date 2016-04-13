public class Solution {
    //Dynamic Programming

    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int len = s1.length();
        //rgtae great
        boolean[][][] dp = new boolean[len + 1][len][len];

        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                dp[1][i][j] = s1.charAt(i) == s2.charAt(j);
            }
        }
        //rgtae great
        for (int i = 1; i <= len; i++) { //len: 5
            for (int j = 0; j <= len - i; j++) { //j: 0 1 2 3
                for (int k = 0; k <= len - i; k++) { //k: 0 1 2 3
                    // dp[1][j][k] = (s1.charAt(j) == s2.charAt(k));

                    //i: 3, j: 0, k: 0
                    for (int l = 1; l < i; l++) {
                        dp[i][j][k] |= (dp[l][j][k] && dp[i - l][j + l][k + l]);
                        dp[i][j][k] |= (dp[l][j][k + i - l] && dp[i - l][j + l][k]);

                        // dp[i][j][k] |= (dp[i - l][j][k + l] && dp[l][j + i - l][k + i - l]);
                        // dp[i][j][k] |= (dp[i - l][j][k + l] && dp[l][j + i - l][k]);

                        if (dp[i][j][k] == true) break;
                    }
                }
            }
        }
        // System.out.println(dp[1][0][2] && dp[2][1][0]);
        // System.out.println(dp[3][0][0]);

        // System.out.println("======");
        // System.out.println("dp[1]");
        // print2DArray(dp[1]);
        // System.out.println("");

        // System.out.println("dp[2]");
        // print2DArray(dp[2]);
        // System.out.println("");

        // System.out.println("dp[3]");
        // print2DArray(dp[3]);
        return dp[len][0][0];
    }
    private static void print2DArray(boolean[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                String r = arr[i][j] == true ? "T": "F";
                System.out.print(r + " ");
            }
            System.out.println("");
        }
    }
    public static void main(String[] args ){
        Solution sol = new Solution();
        String s1 = "rgtae";
        String s2 = "great";
        System.out.println(sol.isScramble(s1, s2));
    }
}
