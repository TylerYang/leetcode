public class SolutionKMP {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        if(haystack.length() < needle.length()) return -1;
        return kmpMatch(haystack, needle); 
    }   
    
    private int kmpMatch(String target, String pattern) {
        int[] next = getNext(pattern);
        int targetIdx = 0, patternIdx = 0, targetLen = target.length(), patternLen = pattern.length();
        while(targetIdx < targetLen && patternIdx < patternLen) {
            if(target.charAt(targetIdx) == pattern.charAt(patternIdx)) {
                targetIdx++;
                patternIdx++;
            } else if(patternIdx == 0){
                targetIdx++;
            } else {
                patternIdx = next[patternIdx - 1] + 1;
            }
        }
        return patternIdx == pattern.length() ? targetIdx - patternIdx : -1;

    }
    private int[] getNext(String pattern) {
        int[] next = new int[pattern.length()];
        next[0] = 1;
        for(int i = 1; i < pattern.length(); i++) {
            int index = next[i - 1];
            char currC = pattern.charAt(i);
            while(index >= 0 && pattern.charAt(index + 1) != currC) {
                index = next[index];
            }
            next[i] = currC == pattern.charAt(index + 1) ? index + 1 : -1;
        } 
        return next;
    }
}
