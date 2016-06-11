public class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 0;
        for (int n: nums) {
            if (map.containsKey(n)) continue;
            int left = map.containsKey(n - 1) ? map.get(n - 1) : 0;
            int right = map.containsKey(n + 1) ? map.get(n + 1) : 0;

            int sum = left + right + 1;
            map.put(n, sum);

            max = Math.max(max, sum);

            map.put(n - left, sum);
            map.put(n + right, sum);
        }
        return max;
    }
}
