package main.java;

import java.util.Map;

public class FacebookLC211WordDictionary {
    private TrieNode root;

    public FacebookLC211WordDictionary() {
        root = new TrieNode();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        if (word == null || word.trim().equals("")) {
            return;
        }
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode node = current.children.get(c);
            if (node == null) {
                node = new TrieNode();
                current.children.put(c, node);
            }
            current = node;
        }

        current.endOfWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(word, root);
    }

    public boolean search(String word, TrieNode node) {
        if (node == null) {
            return false;
        }
        if (word.length() > 0) {
            char c = word.charAt(0);
            Map<Character, TrieNode> children = node.children;
            if (c == '.') {  // if the 1st char is '.', check the next char
                for (char key : children.keySet()) {
                    //return search(word.substring(1), children.get(key));
                    if (search(word.substring(1), children.get(key))) {
                        // if any match return true
                        // not return search(word.substring(1), children.get(key));
                        // see the pattern example
                        // System.out.println(wordDictionary.search(".ad"));  returns false because of pattern
                        return true;
                    }
                }
            } else if (!children.containsKey(c)) {
                return false;
            } else {
                return search(word.substring(1), children.get(c));
            }
            return node.endOfWord;
        } else {
            return node.endOfWord;
        }
    }

    public static void main (String[] args) {
//        Your WordDictionary object will be instantiated and called as such:
        FacebookLC211WordDictionary FacebookLC211WordDictionary = new FacebookLC211WordDictionary();
        FacebookLC211WordDictionary.addWord("word");
        System.out.println(FacebookLC211WordDictionary.search("pattern"));    // false
        System.out.println(FacebookLC211WordDictionary.search(".ord"));       // true
        System.out.println(FacebookLC211WordDictionary.search("..ord"));      // false
        System.out.println(FacebookLC211WordDictionary.search(".or."));       // true
        System.out.println(FacebookLC211WordDictionary.search("...."));       // true
        System.out.println(FacebookLC211WordDictionary.search(".."));         // false
        System.out.println(FacebookLC211WordDictionary.search(".o"));         // false
        FacebookLC211WordDictionary.addWord("bad");
        FacebookLC211WordDictionary.addWord("dad");
        FacebookLC211WordDictionary.addWord("mad");
        FacebookLC211WordDictionary.addWord("pattern");
        System.out.println(FacebookLC211WordDictionary.search("pad"));       // false
        System.out.println(FacebookLC211WordDictionary.search("bad"));       // true
        System.out.println(FacebookLC211WordDictionary.search(".ad"));       // true
        System.out.println(FacebookLC211WordDictionary.search("b.."));       // true
        System.out.println(FacebookLC211WordDictionary.search("pattern"));    // true
        FacebookLC211WordDictionary.addWord("pattern");
    }
}


