public class SolutionBruteForce{ 
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        if(haystack.length() < needle.length()) return -1;
        int hayEnd = haystack.length() - needle.length();
        for(int i = 0; i <= hayEnd; i++) {
            int j = i, k = 0;
            while( k < needle.length() && haystack.charAt(j) == needle.charAt(k)){
                j++;
                k++;
        }
        if(k == needle.length()) return i;
    }
    return -1;
}
