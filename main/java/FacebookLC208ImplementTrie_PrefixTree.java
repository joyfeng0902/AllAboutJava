package main.java;

public class FacebookLC208ImplementTrie_PrefixTree {
    private TrieNode root;

    public FacebookLC208ImplementTrie_PrefixTree() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode current = root; // starting from the root
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode node = current.children.get(c);
            if (node == null) {
                // create a new node
                node = new TrieNode();
                current.children.put(c, node);
            }
            current = node;
        }
        current.endOfWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode current = root; // starting from the root
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode node = current.children.get(c);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return current.endOfWord;     // if it is not endOfWord, return false
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode current = root; // starting from the root
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            TrieNode node = current.children.get(c);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return true;
    }
}

// Your FacebookLC208ImplementTrie_PrefixTree object will be instantiated and called as such:
// FacebookLC208ImplementTrie_PrefixTree trie = new FacebookLC208ImplementTrie_PrefixTree();
// trie.insert("somestring");
// trie.search("key");
