public class Solution {
    public String getHint(String secret, String guess) {
        int len = secret.length();
        if(len == 0) return "0A0B";

        int[] map = new int[10];
        int bCount = 0, cCount = 0;
        for(int i = 0; i < len; i++) {
            char b = secret.charAt(i), c = guess.charAt(i);
            if(b == c) {
                bCount++;
            } else {
                int bPos = (int)b - (int)'0';
                if(map[bPos] < 0) {
                    cCount++;
                }
                map[bPos]++;

                int cPos = (int)c - (int)'0';
                if(map[cPos] > 0) {
                    cCount++;
                }
                map[cPos]--;
            }
        }
        return bCount + "A" + cCount + "B";
    }
    public static void main(String[] args) {
        Solution sol = new Solution();

        String secret = "6244988279";
        String guess =  "3819888600";
        System.out.println(sol.getHint(secret, guess));
    }
}
