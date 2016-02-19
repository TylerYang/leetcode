import java.util.PriorityQueue;
public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        PriorityQueue<Num> pq = new PriorityQueue<Num>();
        for(int i = 0; i < primes.length; i++) {
            pq.add(new Num(primes[i], 1, primes[i]));
        }
        ugly[0] = 1;

        for(int i = 1; i < n; i++) {
            ugly[i] = pq.peek().val;
            while(pq.peek().val == ugly[i]) {
                Num num = pq.poll();
                pq.add(new Num(num.prime * ugly[num.index], num.index + 1, num.prime));
            }
        }
        return ugly[n - 1];
    }
    private class Num implements Comparable<Num> {
        int val;
        int index;
        int prime;
        public Num(int val, int index, int prime) {
            this.val = val;
            this.index = index;
            this.prime = prime;
        }

        @Override
        public int compareTo(Num num) {
            return this.val - num.val;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 12;
        int[] primes = {2, 7, 13, 19};

        System.out.println(sol.nthSuperUglyNumber(n, primes));
    }
}
