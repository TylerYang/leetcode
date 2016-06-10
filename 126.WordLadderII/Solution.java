import java.util.*;
public class Solution {
    List<List<String>> results;
    Map<String, List<String>> adjMap;
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        results = new ArrayList<List<String>>();
        if (wordList.size() == 0) return results;
        adjMap = new HashMap<String, List<String>>();

        Queue<String> queue = new ArrayDeque<String>();
        queue.add(beginWord);


        wordList.add(endWord);

        Map<String, Integer> adjMinMap = new HashMap<String, Integer>();
        for(String word: wordList) {
            adjMinMap.put(word, Integer.MAX_VALUE);
        }
        adjMinMap.put(beginWord, 0);

        int min = Integer.MAX_VALUE;

        while(!queue.isEmpty()) {
            String word = queue.poll();
            int step = adjMinMap.get(word) + 1;

            if (step > min) break;

            for(int i = 0; i < word.length(); i++) {
                StringBuilder builder = new StringBuilder(word);
                for(char ch = 'a'; ch <= 'z'; ch++) {
                    builder.setCharAt(i, ch);
                    String newWord = builder.toString();
                    if (adjMinMap.containsKey(newWord)) {
                        if (step > adjMinMap.get(newWord)) {
                            continue;
                        } else if (step < adjMinMap.get(newWord)) {
                            queue.add(newWord);
                            adjMinMap.put(newWord, step);
                        }

                        if (adjMap.containsKey(newWord)) {
                            adjMap.get(newWord).add(word);
                        } else {
                            List<String> list = new ArrayList<String>();
                            list.add(word);
                            adjMap.put(newWord, list);
                        }

                        if (endWord.equals(newWord)) {
                            min = step;
                        }
                    }
                }
            }
        }
        List<String> result = new ArrayList<String>();
        backtrace(endWord, beginWord, result);

        return results;
    }
    public void backtrace(String word, String start, List<String> list) {
        if (word.equals(start)) {
            list.add(0, word);
            results.add(new ArrayList<String>(list));
            list.remove(0);
            return;
        } else {
            list.add(0, word);
            if (adjMap.get(word) != null) {
                for (String adjWord: adjMap.get(word)) {
                    backtrace(adjWord, start, list);
                }
            }
            list.remove(0);
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();

        String beginWord = "hit";
        String endWord = "cbt";
        Set<String> wordList = new HashSet<String>(Arrays.asList("hot","dot","dog","lot","log", "cog", "cbg", "cbt"));

        System.out.println(sol.findLadders(beginWord, endWord, wordList));
    }
}
