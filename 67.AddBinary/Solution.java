public class Solution {
    public String addBinary(String a, String b) {
        if(a.length() == 0) return b;
        if(b.length() == 0) return a;
        if(a.length() < b.length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }
        char[] cArr = new char[a.length()];
        int j = b.length() - 1, inc = 0, base = 2;
        for(int i = a.length() - 1; i >= 0; i--) {
            int m = (int)(a.charAt(i) - '0');
            int n = j >= 0 ? (int)(b.charAt(j--) - '0') : 0;
            int r = m + n + inc;
            cArr[i] = (char)(r % base + '0');
            inc = r / base;
        }
        String str = new String(cArr);
        if(inc == 1) str = '1' + str;
        return str;
    }
}