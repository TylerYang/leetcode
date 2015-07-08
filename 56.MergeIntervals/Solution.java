import java.util.List;
import java.util.ArrayList;
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() <= 1) return intervals;
        List<Interval> rList = new ArrayList<Interval>();
        for(int i = 0; i < intervals.size(); i++) {
            Interval iter = intervals.get(i);
            int j = 0;
            while(j < rList.size() && rList.get(j).end < iter.start) j++;
            if(j == intervals.size()) {
                rList.add(iter);
            } else {
                Interval currIter = rList.get(j);
                if(currIter.start > iter.end) {
                    rList.add(j, iter);
                } else {
                    currIter.start = currIter.start < iter.start ?  currIter.start : iter.start;
                    currIter.end =  currIter.end > iter.end ? currIter.end : iter.end;
                    Interval pIter = null, nIter = null;
                    int k = j - 1;
                    while( k >= 0 && rList.get(k).end >= currIter.start) {
                        pIter = rList.remove(k);
                        k--;
                    }
                    if(pIter != null) currIter.start = pIter.start;
                    k += 2;
                    
                    while(k < rList.size() && rList.get(k).start <= currIter.end) {
                        nIter = rList.remove(k);
                    } 
                    if(nIter != null) currIter.end = currIter.end > nIter.end ? currIter.end : nIter.end;
                }
            }
        }
        return rList;
    }
}
