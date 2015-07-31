public class Solution {
    public int minCut(String s) {
		boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            for(int j = i; j >= 0; j--) {
                if(s.charAt(j) == s.charAt(i) && (i - j < 2 || dp[j + 1][i - 1] == true)) {
                    dp[j][i] = true;
                }
            }
        }
		
		//nice
		int[] minCut = new int[s.length() + 1];
		for(int i = 0; i < minCut.length; i++) {
			minCut[i] = s.length() - i - 1;
		}
		for(int i = s.length() - 1; i >= 0; i--) {
			for(int j = i; j < s.length(); j++) {
				if(dp[i][j] == true) {
					minCut[i] = Math.min(minCut[i], 1 + minCut[j + 1]);
				}
			}
		}
		return minCut[0];
		
    }
}