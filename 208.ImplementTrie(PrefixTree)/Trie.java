public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if(word.length() == 0) return;
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int idx = c - 'a';
            if(node.letters[idx] == null) {
                node.letters[idx] = new TrieNode();
            }
            node = node.letters[idx];
        }
        node.isEnd = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        int i = 0;
        TrieNode node = root;
        while(i < word.length()) {
            char c = word.charAt(i);
            int idx = c - 'a';
            if(node.letters[idx] == null) return false;
            
            node = node.letters[idx];
            i++;
        }
        return node.isEnd;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        int i = 0;
        TrieNode node = root;
        while(i < prefix.length()) {
             char c = prefix.charAt(i);
            int idx = c - 'a';
            if(node.letters[idx] == null) return false;
            
            node = node.letters[idx];
            i++;
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");