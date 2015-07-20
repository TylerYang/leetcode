public class Solution {
    public int numTrees(int n) {
        if(n <= 1) return 1;
        int num = 0;
        int[] numArr = new int[n + 1];
        numArr[0] = 1;
        numArr[1] = 1;
        numArr[2] = 2;

        for(int i = 3; i <= n; i++) {
            int total = 0;
            for(int j = 1; j <= i; j++) {
                int leftNum = numArr[j - 1];
                int rightNum = numArr[i - j];
                total += leftNum * rightNum;
            }
            numArr[i] = total;
        }
        
        return numArr[n];
    }
}