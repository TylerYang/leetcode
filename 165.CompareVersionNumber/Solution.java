public class Solution {
    public int compareVersion(String version1, String version2) {
        int i = 0, j = 0;
        while(i < version1.length() || j < version2.length()) {
            while(i < version1.length() && version1.charAt(i) == '0' && version1.charAt(i) != '.') i++;
            while(j < version2.length() && version2.charAt(j) == '0' && version2.charAt(j) != '.') j++;
            
            int nextI = i, nextJ = j;
            while(nextI < version1.length() && version1.charAt(nextI) != '.') nextI++;
            while(nextJ < version2.length() && version2.charAt(nextJ) != '.') nextJ++;
            
            String str1 = version1.substring(i, nextI);
            String str2 = version2.substring(j, nextJ);
            
            int r = compare(str1, str2);
            if(r != 0) return r;
            
            i = nextI < version1.length() ? nextI + 1 : nextI;
            j = nextJ < version2.length() ? nextJ + 1 : nextJ;
        }
        return 0;
    }
    private int compare(String str1, String str2) {
        if(str1.length() != str2.length()) return str1.length() < str2.length() ? -1 : 1;
        for(int i = 0; i < str1.length(); i++) {
            if(str1.charAt(i) < str2.charAt(i)) {
                return -1;
            } else if(str1.charAt(i) > str2.charAt(i)) {
                return 1;
            }
        }
        return 0;
    }
}