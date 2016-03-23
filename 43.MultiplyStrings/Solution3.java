public class Solution3 {
    public String multiply(String num1, String num2) {
        int[] arr = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int p1 = arr.length + 1 + i + j - num1.length() - num2.length();
                int p2 = p1 - 1;
                int tmp = ((int)num1.charAt(i) - (int)'0') * ((int)num2.charAt(j) - (int)'0');
                arr[p1] += tmp;
                arr[p2] += arr[p1] / 10;
                arr[p1] %= 10;
                
            }
        }
        StringBuffer sBuff = new StringBuffer();
        for(int i = 0; i < arr.length; i++) {
            if(sBuff.length() != 0 || arr[i] != 0) {
                sBuff.append(arr[i]);
            }
        }
        return sBuff.length() == 0 ? "0" : sBuff.toString();
    }
}
