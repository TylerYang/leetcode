public class Solution {
    public int hIndex(int[] citations) {
        int h = 0;
        int len = citations.length;
        int low = 0, high = citations.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            h = Math.max(h, Math.min(citations[mid], len - mid));
            if(citations[mid] > (len - mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return h;
    }
}
