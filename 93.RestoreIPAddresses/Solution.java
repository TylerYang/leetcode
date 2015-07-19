import java.util.*;
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        return restoreIpAddr(s, 4);
    }
    public List<String> restoreIpAddr(String s, int level) {
        List<String> rList = new ArrayList<String>();
        if(level * 3 < s.length() || s.length() < level) return rList;
        if(level == 1) {
            if(isValid(s)) rList.add(s);
            return rList;
        }

        for(int i = 0; i <= 2 && s.length() - i >= level; i++) {
            String preS = s.substring(0, i + 1);
            if(isValid(preS)) {
                List<String> subList = restoreIpAddr(s.substring(i + 1), level - 1);
                for(int j = 0; j < subList.size(); j++) {
                    StringBuffer sBuff = new StringBuffer(preS);
                    sBuff.append(".");
                    sBuff.append(subList.get(j));
                    rList.add(sBuff.toString());
                } 
            }
        }
        return rList;
    }
    private boolean isValid(String s) { 
        if(s.length() > 1 && s.charAt(0) == '0') return false;
        return s.length() <= 2 || Integer.parseInt(s) < 256;

    }
}
