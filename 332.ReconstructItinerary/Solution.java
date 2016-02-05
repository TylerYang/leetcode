import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Collections;

public class Solution {
    //didn't compress space version
    public List<String> findItinerary(String[][] tickets) {
      List<String> rList = new ArrayList<String>();
      if(tickets.length == 0) return rList;

      Map<String, List<String>> locMap = new HashMap<String, List<String>>();
      for(int i = 0; i < tickets.length; i++) {
        String from = tickets[i][0], to = tickets[i][1];
        List<String> sList;
        if(locMap.get(from) != null) {
          sList = locMap.get(from);
        } else {
          sList = new LinkedList<String>();
          locMap.put(from, sList);
        }
        sList.add(to);
      }
      for(String key: locMap.keySet()) {
        List<String> sList = locMap.get(key);
        Collections.sort(sList);
      }
      return genItinerary(locMap, "JFK");
    }

    public List<String> genItinerary(Map<String, List<String>> locMap, String start) {
      List<String> rList = new ArrayList<String>();
      if(locMap.size() == 0) return rList;
      while(start != null) {
        List<String> sList = locMap.get(start);
        rList.add(start);
        if(sList == null) {
          if(rList.size() == 1) break;
          start = null;

          for(int i = rList.size() - 2; i >= 0; i--) {
            List<String> nrList = genItinerary(locMap, rList.get(i));
            if(nrList.size() > 1) {
              nrList.remove(nrList.size() - 1);
              rList.addAll(i, nrList);
            }
          }
        } else {
          String tmpStart = start;
          start = sList.get(0);
          sList.remove(0);
          if(sList.size() == 0) {
            locMap.remove(tmpStart);
          }
        }
      }
      return rList;
    }
}
