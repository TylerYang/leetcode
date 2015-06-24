public class Solution{
    public int lengthOfLongestSubstring(String s){
        //keyword: slide window
        int sLen = s.length();
        int[] cArr = new int[256]; //store all the characters
        int max = 0, start = 0;
        for(int i = 0; i < sLen; i++){
            int endCode = (int)s.charAt(i);
            if(cArr[endCode] == 0){
                cArr[endCode] = 1;
                if(i - start + 1 > max) max = i - start + 1;    
            } else {
                int startCode = (int)s.charAt(start);
                while(startCode != endCode){
                    cArr[startCode] = 0;
                    start++;
                    startCode = (int)s.charAt(start);
                }
                start++;
            }
        }
        return max;
    }
}
