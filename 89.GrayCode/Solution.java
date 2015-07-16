import java.util.*;
public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> rList = new ArrayList<Integer>();
        rList.add(0);
        for(int i = 0; i < n; i++) {
            int r = 1 << i;
            for(int j = rList.size(); j >= 0; j--) {
                rList.add(rList.get(j) + r);
            }
        }
        return rList;
    }
}
