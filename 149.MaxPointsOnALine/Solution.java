/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
import java.util.*;
public class Solution {
    public int maxPoints(Point[] points) {
        if(points.length <= 2) return points.length;
        Map<Double, Integer> slopeMap;
        int max = 0;
        for(int i = 0; i < points.length; i++) { 
            int dup = 0;
            slopeMap = new HashMap<Double, Integer>();
            Point currP = points[i];
            
            for(int j = 0; j < points.length; j++) {
                Point p = points[j];
                
                if(i != j) { 
                    if(currP.x == p.x && currP.y == p.y) {
                        dup++;
                        if(dup >= max) max = dup + 1;
                    } else {
                        double slope = currP.y == p.y ? (double) Integer.MAX_VALUE : ((double)currP.x - (double)p.x) / ((double)currP.y - (double)p.y);
                        if(slopeMap.containsKey(slope)) {
                            slopeMap.put(slope, slopeMap.get(slope) + 1);
                        } else {
                            slopeMap.put(slope, 2);
                        }
                        if(max < slopeMap.get(slope) + dup) max = slopeMap.get(slope) + dup;
                    }
                }
            }
        }
        return max;
    }
	public static void main(String[] args) {
		Solution sol = new Solution();
		Point[] points = new Point[4];
		points[0] = new Point(-4, 1);
		points[1] = new Point(-7, 7);
		points[2] = new Point(-1, 5);
		points[3] = new Point(9, -25);
		System.out.println(sol.maxPoints(points));
		

	}
}