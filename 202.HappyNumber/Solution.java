public class Solution {
    public boolean isHappy(int n) {
        if(n <= 0) return false;
        Set<Integer> set = new HashSet<Integer>();
        set.add(0);
        set.add(1);
        
        while(set.contains(n) == false) {
            set.add(n);
            n = genNext(n);
        }
        return n == 1;
    }
    private int genNext(int n) {
        int r = 0;
        while(n != 0) {
            r += Math.pow((n % 10), 2);
            n /= 10;
        }
        return r;
    }
}