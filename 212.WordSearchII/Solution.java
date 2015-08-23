public class Solution {
    List<String> rList;
    boolean[][] mark;
    Set<String> wordSet;
    
    public List<String> findWords(char[][] board, String[] words) {
        rList = new ArrayList<String>();
        mark = new boolean[board.length][board[0].length];
        wordSet = new HashSet<String>();
        
        Trie trie = new Trie();
        for(int i = 0; i < words.length; i++) {
            trie.insert(words[i], i);
        }
        
        TrieNode node = trie.getRoot();
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
				int idx = board[i][j] - 'a';
				
				if(node.letters[idx] != null) {
					findWordsHelper(board, words, i, j, node.letters[idx]);
				}
				
				
            }
        }
        for(String word : wordSet) {
            rList.add(word);   
        }
        return rList;
    }
    private void findWordsHelper(char[][] board, String[] words, int i, int j, TrieNode node) {
        mark[i][j] = true;

        if(node.isEnd == true) {
            for(int k = 0; k < node.wordsIndexes.size(); k++) {
                //rList.add(words[node.wordsIndexes.get(k)]);
                wordSet.add(words[node.wordsIndexes.get(k)]);
            }
        }

		
        if(i > 0 && node.containsChar(board[i - 1][j]) && !mark[i - 1][j]) {
            int nextIdx = board[i - 1][j] - 'a';
            findWordsHelper(board, words, i - 1, j, node.letters[nextIdx]);
        }
        if(j > 0 && node.containsChar(board[i][j - 1]) && !mark[i][j - 1]) {
            int nextIdx = board[i][j - 1] - 'a';
            findWordsHelper(board, words, i, j - 1, node.letters[nextIdx]);
        }
        if(i < board.length - 1 && node.containsChar(board[i + 1][j]) && !mark[i + 1][j]) {
            int nextIdx = board[i + 1][j] - 'a';
            findWordsHelper(board, words, i + 1, j, node.letters[nextIdx]);
        }
        if(j < board[0].length - 1 && node.containsChar(board[i][j + 1]) && !mark[i][j + 1]){
            int nextIdx = board[i][j + 1] - 'a';
            findWordsHelper(board, words, i, j + 1, node.letters[nextIdx]);
        }
		mark[i][j] = false;
    }
    private class Trie {
        TrieNode root;
        public Trie() {
            root = new TrieNode();
        }
        public TrieNode getRoot() {
            return root;
        }
        public void insert(String s, int index) {
            TrieNode node = root;
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int idx = c - 'a';
                if(node.letters[idx] == null) node.letters[idx] = new TrieNode();
                node = node.letters[idx];
            }
            if(node.isEnd == false) {
                node.isEnd = true;
                node.wordsIndexes = new ArrayList<Integer>();
            }
            node.wordsIndexes.add(index);
        }
        public boolean search(String word) {
            TrieNode node = root;
            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int idx = c - 'a';
                if(node.letters[idx] == null) return false;
                node = node.letters[idx];
            }
            return node.isEnd;
        }
        
    }
    private class TrieNode {
        boolean isEnd;
        List<Integer> wordsIndexes;
        TrieNode[] letters;
        
        public TrieNode() {
            isEnd = false;
            letters = new TrieNode[26];
        }
        private boolean containsChar(char c) {
            int idx = c - 'a';
            return letters[idx] != null;
        }
    }
}