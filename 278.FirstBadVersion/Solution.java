public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 0, right = n;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(isBadVersion(mid) == true) {
                if(mid == left) return mid;
                right = mid - 1;
            } else {
                if(left == right && isBadVersion(right + 1) == true) return right + 1;
                left = mid + 1;
            }
        }
        return -1;
    }
}
