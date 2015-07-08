import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
public class Solution2 {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> rList = new ArrayList<Interval>();
        Comparator<Interval> comp = new Comparator<Interval>() {
            public int compare(Interval inter1, Interval inter2) {
                if(inter1.start == inter2.start) return inter1.end - inter1.end;
                return inter1.start - inter2.start;
            }
        };
        
        Collections.sort(intervals, comp);
        rList.add(intervals.get(0));
        for(int i = 1; i < intervals.size(); i++) {
            Interval inter = intervals.get(i);
            Interval lastInter = rList.get(rList.size() - 1);
            if(inter.start > lastInter.end) {
                rList.add(inter);
            } else {
                lastInter.end = inter.end > lastInter.end ? inter.end : lastInter.end;
            }
        } 
        
        return rList;
    }

}
