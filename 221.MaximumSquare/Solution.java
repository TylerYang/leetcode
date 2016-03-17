public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        int[] arr = new int[matrix[0].length];
        int max = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(arr[j] == 0) {
                    arr[j] = matrix[i][j] - '0';
                } else {
                    if(matrix[i][j] == '1') {
                        arr[j]++;
                    } else {
                        arr[j] = 0;
                    }
                }
            }
            for(int j = 0; j < arr.length; j++) {
                int tmp = arr[j];
                while(tmp > 0) {
                    int h = 0;
                    for(; h < tmp && j + h < arr.length && arr[j + h] >= tmp; h++) {}
                    if(h == tmp && tmp * tmp > max){
                        max = tmp * tmp;
                        break;
                    }
                    tmp--;
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        char[][] matrix = {
            {'0'}
        };
        System.out.println(sol.maximalSquare(matrix));
    }
}
