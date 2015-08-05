import java.util.*;
public class Solution {
	private HashMap<String, List<String>> wordMap = new HashMap<String, List<String>>();
    public List<String> wordBreak(String s, Set<String> wordDict) {
        if(wordMap.containsKey(s)){
            return wordMap.get(s);
        }
        List<String> rList = new ArrayList<String>();
        if(wordDict.contains(s)) rList.add(s);
    
        for(int i = s.length() - 1; i > 0; i--) {
            String subStr = s.substring(i, s.length());
            if(wordDict.contains(subStr)) {
                List<String> subList = wordBreak(s.substring(0, i), wordDict);
                for(int j = 0; j < subList.size(); j++) {
                    rList.add(subList.get(j) + " " + subStr);
                }
            }
        }
        wordMap.put(s, rList);
        return rList;
    }
	public static void main(String[] args) {
		Solution sol = new Solution();
		Set<String> wordDict = new HashSet<String>();
		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("and");
		wordDict.add("sand");
		wordDict.add("dog");
		
		
		System.out.println(sol.wordBreak("catsanddog", wordDict));
	}
}