/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        PriorityQueue<Interval> pq = new PriorityQueue<Interval>(new Comparator<Interval>() {
                public int compare(Interval iter1, Interval iter2) {
                    if (iter1.start == iter2.start) {
                        return iter1.end - iter2.end;
                    } else {
                       return iter1.start - iter2.start; 
                    }
                }
            });
        
        for (Interval inter : intervals) {
            pq.add(inter);
        }
        List<Interval> list = new ArrayList<Interval>();
        while (pq.size() != 0) {
            Interval inter = pq.poll();
            if (list.size() == 0) {
                list.add(inter);
            } else {
                Interval prevInter = list.get(list.size() - 1);
                if (prevInter.end < inter.start) {
                    list.add(inter);
                } else {
                    prevInter.end = Math.max(prevInter.end, inter.end);
                }
            }
        }
        return list;
    }
}
