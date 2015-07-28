import java.util.*;
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> rlist = new ArrayList<Integer>();
        rlist.add(1);
        int lastVal = 1;
        for(int i = 1; i <= rowIndex; i++) {
            for(int j = 1; j < i; j++) {
                int tmp = rlist.get(j);
                rlist.set(j, lastVal + tmp);
                lastVal = tmp;
            }
            rlist.add(1);
        }

        return rlist;
    }
}
