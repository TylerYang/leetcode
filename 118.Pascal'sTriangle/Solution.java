import java.util.*;
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rlist = new ArrayList<List<Integer>>();
        if(numRows == 0) return rlist;
        List<Integer> slist = new ArrayList<Integer>();
        slist.add(1);
        for(int i = 2; i <= numRows; i++) {
            slist = new ArrayList<Integer>();
            List<Integer> lastList = rlist.get(i - 2);
            for(int j = 1; j <= i; j++) {
                if(j == 1 || j == i) {
                    slist.add(1);
                } else {
                    slist.add(lastList.get(j - 1) + lastList.get(j - 2));
                }
            }
            rlist.add(slist);
        }
        return rlist;
    }
}
