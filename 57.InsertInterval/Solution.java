import java.util.List;
import java.util.ArrayList;

public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(newInterval == null) return intervals;
        int i = 0;
        while(i < intervals.size() && intervals.get(i).end < newInterval.start) i++;

        if(i == intervals.size()) {
            intervals.add(newInterval);
            return intervals;
        } else {
            Interval iter = intervals.get(i);
            if(iter.start > newInterval.end) {
                intervals.add(i, newInterval);
            } else {
                iter.start = iter.start < newInterval.start ? iter.start : newInterval.start;
                iter.end = iter.end > newInterval.end ? iter.end : newInterval.end;  

                Interval pIter = null, nIter = null; 
                int k = i - 1; 
                while(k >= 0 && intervals.get(k).end >= iter.start) {
                    pIter = intervals.remove(k);
                    k--;
                }
                if(pIter != null) iter.start = pIter.start;
                
                k += 2;
                while(k < intervals.size() && intervals.get(k).start <= iter.end) {
                    nIter = intervals.remove(k);
                }
                if(nIter != null) iter.end = iter.end > nIter.end ? iter.end : nIter.end;
            }
        }
        return intervals;
    }
}
