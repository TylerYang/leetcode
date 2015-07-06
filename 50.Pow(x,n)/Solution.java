public class Solution{
    public double myPow(double x, int n) {
        if(n == 0) return 1.0;
        if(x == 0) return n > 0 ? 0.0 : Double.POSITIVE_INFINITY;
        int m = Math.abs(n);
        String b = Integer.toBinaryString(m);
        double r = 1.0;

        for(int i = b.length() - 1; i >= 0; i--) {
            if(b.charAt(i) == '1') r *= x;
            x *= x;
        }

        return n > 0 ? r : 1 / r;
    }
}
