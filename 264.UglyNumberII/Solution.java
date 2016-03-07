import java.util.Comparator;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.PriorityQueue;
public class Solution {
    //indexed heap
    public int nthUglyNumber(int n) {
        int[] primes = {2, 3, 5};
        ArrayList<Integer> uglyList = new ArrayList<Integer>(Arrays.asList(1));
        PriorityQueue<Number> pq = new PriorityQueue<Number>(4, new Comparator<Number>(){
            public int compare(Number n1, Number n2) {
                return n1.val - n2.val;
            }
        });
        for(int i = 0; i < primes.length; i++) {
            int prime = primes[i];
            pq.add(new Number(prime, prime, i + 1));
        }
        while(uglyList.size() < n) {
            Number num = pq.poll();
            if(uglyList.get(uglyList.size() - 1) != num.val) {
                uglyList.add(num.val);
            }
            num.val = num.prime * uglyList.get(num.index);
            num.index = num.index + 1;
            pq.add(num);
        }

        return uglyList.get(n - 1);
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 11;
        System.out.println(sol.nthUglyNumber(n));
    }
}
class Number {
    int val;
    int prime;
    int index;
    public Number(int val, int prime, int index) {
        this.val = val;
        this.prime = prime;
        this.index = index;
    }
}
