package main.java;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    // Initialize your data structure here.
    Map<Character, TrieNode> children;
    boolean endOfWord;

    public TrieNode() {
        children = new HashMap();
        endOfWord = false;
    }
}

