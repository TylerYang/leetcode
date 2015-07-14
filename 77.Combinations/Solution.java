import java.util.*;
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if(n == 0) return new ArrayList<List<Integer>>();
        return combineBetween(1, n, k);
    }
    private List<List<Integer>> combineBetween(int m, int n, int k) {

        List<List<Integer>> rList = new ArrayList<List<Integer>>();
        if(k == 0) return rList;
        
        for(int i = m; i <= n - k + 1; i++) {
            if(k > 1) {
                List<List<Integer>> subList = combineBetween(i + 1, n, k - 1);
                for(int j = 0; j < subList.size(); j++){
                    List<Integer> l = new ArrayList<Integer>();
                    l.add(i);
                    l.addAll(subList.get(j));
                    rList.add(l);
                }
            } else {
                List<Integer> l = new ArrayList<Integer>();
                l.add(i);
                rList.add(l);
            }
        }
        return rList;
    }
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.combine(13, 10));
	}
}
