public class Solution {
    private class Bucket {
        int max, min;
        public Bucket() {
            this.max = -1;
            this.min = -1;
        }
    }
    public int maximumGap(int[] nums) {
        if(nums.length < 2) return 0;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > max) max = nums[i];
            if(nums[i] < min) min = nums[i];
        }
        Bucket[] buckets = new Bucket[nums.length + 1];
        
        for(int i = 0; i < buckets.length; i++) {
            buckets[i] = new Bucket();
        }
        
        double interval = (double) nums.length / (max - min);
        for(int i = 0; i < nums.length; i++) {
            int index = (int) ((nums[i] - min) * interval);
            if(buckets[index].min == -1) {
                buckets[index].max = nums[i];
                buckets[index].min = nums[i];
            } else {
                if(buckets[index].min > nums[i]) buckets[index].min = nums[i];
                if(buckets[index].max < nums[i]) buckets[index].max = nums[i];
            }
        }
        
        int gap = Integer.MIN_VALUE, prev = buckets[0].max;
        for(int i = 0; i < buckets.length; i++) {
            if(buckets[i].min != -1) {
                if(buckets[i].min - prev > gap) gap = buckets[i].min - prev;
                prev = buckets[i].max;
            }
        }
        return gap;
    }
}