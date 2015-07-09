public class Solution {
    public String getPermutation(int n, int k) {
        char[] arr = new char[n];
        int fac = 1;
        for(int i = 0; i < n; i++) {
            arr[i] = (char) ('1' + i);
            fac *= i + 1;
        } 
        k = --k % fac;
        fac /= n;
        for(int i = 0; i < n - 1; i++) {
            int selI = k / fac;
            k %= fac;
            fac /= n - i - 1;
            char tmp = arr[selI + i];
            for(int j = selI; j > 0; j--) {
                arr[i + j] = arr[i + j - 1];
            }
            arr[i] = tmp;
        }
        return new String(arr);
    }
}
