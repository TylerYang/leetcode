import java.util.*;
public class Solution {
    Queue<String> wordQueue;
    Queue<Integer> lengthQueue;
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        if(wordDict.size() == 0) return 0;
        
        wordQueue = new ArrayDeque<String>();
        lengthQueue = new ArrayDeque<Integer>();
        
        wordQueue.add(beginWord);
        lengthQueue.add(1);

        return getLadderLength(endWord, wordDict);
    }
    private int getLadderLength(String endWord, Set<String> wordDict) {
        while(wordQueue.isEmpty() == false) {
            String beginWord = wordQueue.poll();
            int len = lengthQueue.poll();
            
            char[] cArr = beginWord.toCharArray();
            for(int i = 0; i < beginWord.length(); i++) {
                for(char c = 'a'; c <= 'z'; c++) {
                    if(c == cArr[i]) continue;
                    cArr[i] = c;
                    String newS = new String(cArr);
                    if(newS.equals(endWord)) return len + 1;
                    
                    if(wordDict.contains(newS)) {
                        wordDict.remove(newS);
                        wordQueue.add(newS);
                        lengthQueue.add(len + 1);
                    }
                }
            }
        }
        return 0;
    }
}

