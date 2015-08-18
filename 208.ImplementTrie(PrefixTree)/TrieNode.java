class TrieNode {
    // Initialize your data structure here.
    boolean isEnd;
    TrieNode[] letters;
    public TrieNode() {
        letters = new TrieNode[26];
        isEnd = false;
    }
}
