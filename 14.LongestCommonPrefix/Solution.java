public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        String common = strs[0];
        int end = common.length();
        for(int i = 1; i < strs.length; i++){
            String currStr = strs[i];
            int j = 0, k = 0;
            while(j < end && k < currStr.length() && common.charAt(j) == currStr.charAt(k)) {
                j++;
                k++;
            }
            end = j;
        }
        return common.substring(0, end);
    }
}
