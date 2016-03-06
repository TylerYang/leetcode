public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        int len = citations.length;
        for(int i = 0; i < len; i++) {
            h = Math.max(h, Math.min(len - i, citations[i]));
        }
        return h;
    }
}
