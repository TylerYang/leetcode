public class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> num = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) num.add(i);
        int[] facts = new int[n];
        facts[0] = 1;
        for (int i = 1; i < n; i++) {
            facts[i] = facts[i - 1] * i;
        }
        k--;
        StringBuffer sBuff = new StringBuffer();

        for (int i = n; i > 0; i--) {
            int idx = k / facts[i - 1];
            k %= facts[i - 1];
            sBuff.append(num.remove(idx));
        }
        return sBuff.toString();
    }
}
