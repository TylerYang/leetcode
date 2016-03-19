import java.util.*;
public class Solution {
    //[ [2 9 10], [3 7 15], [5 12 12]]
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<int[]>();
        List<int[]> heights = new ArrayList<int[]>();
        for(int[] build : buildings) {
            heights.add(new int[]{build[0], -build[2]});
            heights.add(new int[]{build[1], build[2]});
        }

        Collections.sort(heights, (a, b) -> {
            if(a[0] != b[0]){
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> (b - a));
        pq.offer(0);
        int prevHeight = 0;
        for(int[] point : heights) {
            if(point[1] < 0) {
                pq.offer(-point[1]);
            } else {
                pq.remove(point[1]);
            }
            int currHeight = pq.peek();
            if(prevHeight != currHeight) {
                result.add(point[0], currHeight);
                prevHeight = currHeight;
            }
        }
        return result;
    }
    public static void main(String[] args ) {
        Solution sol = new Solution();
        int[][] buildings = { {2, 9, 10}, {3, 7, 15}};
        System.out.println(sol.getSkyline(buildings));

    }
}
