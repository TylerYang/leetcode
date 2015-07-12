public class Solution {
    public String simplifyPath(String path) {
        if(path.length() == 0) return path;
        List<String> sList = new ArrayList<String>();
        int i = 0;
        while(true) {
            while(i < path.length() && path.charAt(i) == '/') i++;
            if(i == path.length()) break;
            int j = i + 1;
            while(j < path.length() && path.charAt(j) != '/') {
                j++;
            }
            if(j - i >= 1) {
                String subStr = path.substring(i, j);
                if(subStr.charAt(0) == '.' && subStr.length() <= 2) {
                    if(subStr.length() == 2 && sList.size() > 0) {
                        sList.remove(sList.size() - 1);
                    }
                } else {
                    sList.add(subStr);
                }
            }
            i = j;
        }
        if(sList.size() == 0) return "/";
        StringBuffer sBuff = new StringBuffer();
        for(int j = 0; j < sList.size(); j++) {
            sBuff.append("/");
            sBuff.append(sList.get(j));
        }
        return sBuff.toString();
    }
}
