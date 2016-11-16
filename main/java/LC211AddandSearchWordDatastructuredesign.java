package main.java;

/**
 * Created by joyfeng on 11/13/2016.
 */
public class LC211AddandSearchWordDatastructuredesign {
    // similar with Implement Trie.
    // To handle the "." case for this problem, we need to search all possible paths, instead of one path.
    TrieNode root;
    LC211AddandSearchWordDatastructuredesign() {
        root = new TrieNode();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode current= root;
        for (int i = 0;i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode node = current.children.get(c);
            if (node == null) {
                node = new TrieNode();
                current.children.put(c, node);  // don't forget
            }
            current = node;
        }

        current.endOfWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return dfsSearch(root, word, 0);
    }

    boolean dfsSearch(TrieNode current, String word, int start) {
        if (current == null) {
            return false;
        }
        int length = word.length();
        if (start == length) {
            return current.endOfWord;
        }
        char c = word.charAt(start);
        if (c == '.') {
            for (TrieNode node : current.children.values()) {
                if(start == word.length()-1 && node.endOfWord){
                    return true;
                }
                if(dfsSearch(node, word, start + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            return dfsSearch(current.children.get(c), word, start+1);
        }
    }

    public static void main(String[] args) {
        LC211AddandSearchWordDatastructuredesign l = new LC211AddandSearchWordDatastructuredesign();
        l.addWord("a");
        l.search(".");
    }
}
