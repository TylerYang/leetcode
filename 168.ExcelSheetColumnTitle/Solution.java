public class Solution {
    public String convertToTitle(int n) {
        StringBuffer sBuff = new StringBuffer();
        while(n > 26) {
            int m = (n - 1) % 26;
            sBuff.insert(0, getAlphabet(m));
            n = (n - 1) / 26;
        }
        sBuff.insert(0, getAlphabet(n - 1));
        return sBuff.toString();
    }
    private char getAlphabet(int n) {
        return (char)('A' + n);
    }
}