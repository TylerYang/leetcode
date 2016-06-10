public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (wordList.size() == 0) return 0;
        wordList.add(endWord);
        
        Queue<String> queue = new ArrayDeque<String>();
        queue.add(beginWord);
        
        Map<String, Integer> ladder = new HashMap<String, Integer>();
        for (String word: wordList) {
            ladder.put(word, Integer.MAX_VALUE);
        }
        ladder.put(beginWord, 0);
        
        int min = 0;
        while(!queue.isEmpty()) {
            String word = queue.poll();
            int step = ladder.get(word) + 1;
            if (min != 0) break;
            for (int i = 0; i < word.length(); i++) {
                StringBuilder builder = new StringBuilder(word);
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    builder.setCharAt(i, ch);
                    String newWord = builder.toString();
                    if (ladder.containsKey(newWord)) {
                        if (step > ladder.get(newWord)) {
                            continue;
                        } else if (step < ladder.get(newWord)) {
                            queue.add(newWord);
                            ladder.put(newWord, step);
                        }
                        
                        if (endWord.equals(newWord)) {
                            min = step;
                            break;
                        }
                    }
                }
            }
        }
        return min == 0 ? min: min + 1;
    }
}
