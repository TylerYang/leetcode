public class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int idx = c - 'a';
            if(node.letters[idx] == null) node.letters[idx] = new TrieNode();
            
            node = node.letters[idx];
        }
        node.isEnd = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(root, word, 0);
    }
    private boolean search(TrieNode node, String word, int i) {
        while(node != null && i < word.length() && word.charAt(i) != '.') {
			char c = word.charAt(i++);
			int idx = c - 'a';
            node = node.letters[idx];
        }
		if(node == null) return false;
        if(i == word.length()){
            return node.isEnd;
        } else {
            for(int j = 0; j < 26; j++) {
                if(node.letters[j] != null && search(node.letters[j], word, i + 1)) {
                    return true;
                }
            }  
        }
        return false;
    }
    private class TrieNode {
        boolean isEnd;
        TrieNode[] letters;
        public TrieNode() {
            isEnd = false;
            letters = new TrieNode[26];
        }
    }
	public static void main(String[] args) {
		WordDictionary wordDictionary = new WordDictionary();
		wordDictionary.addWord("worrd");
		System.out.println(wordDictionary.search("wor.d"));
	}
    
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");