import java.util.List;
import java.util.ArrayList;

public class Solution2 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> rList = new ArrayList<Interval>();
        for(Interval inter : intervals) {
            if(inter.end < newInterval.start) {
                rList.add(inter);
            } else if(inter.start > newInterval.end) {
                rList.add(newInterval);
                newInterval = inter;
            } else {
                newInterval.start = inter.start < newInterval.start ? inter.start : newInterval.start;
                newInterval.end = inter.end > newInterval.end ? inter.end : newInterval.end; 
            }
        }
        rList.add(newInterval);
        return rList;
    }

}
