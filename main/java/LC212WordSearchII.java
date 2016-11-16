package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// board.length not board.length()
// remember to set visited [i][j] to be false at the end of dfs
// use a Set instead of List because each element in Set if unique
// Set<String> result = new HashSet<>();  not  Set<String> result = new Set<>(); (Set is abstract; cannot be instantiated), return new ArrayList<String>(result);
// int m = board.length; int n = board[0].length;

public class LC212WordSearchII {
    Set<String> result = new HashSet<String>();

    class TrieNode {
        Map<Character, TrieNode> children;
        boolean endOfWord;
        TrieNode() {
            children = new HashMap<Character, TrieNode>();
            endOfWord = false;
        }
    }
    class Trie {
        TrieNode root = new TrieNode();
        // add word
        void addWord(String word) {
            if (word == null || word.length() == 0) {
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
        // search word
        boolean search(String word) {
            if (word == null || word.length() == 0) {
                return false;
            }
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                TrieNode node = current.children.get(c);
                if (node == null) {
                    return false;
                }
                current = node;
            }
            return current.endOfWord;
        }

        // start with?
        boolean startWith(String prefix) {
            if (prefix == null || prefix.length() == 0) {
                return false;
            }
            TrieNode current = root;
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

    // dfs method to search if an given word is in the board
    public void dfs (char[][] board, boolean[][] visited, String word, int i, int j, Trie dictionary) {
        int m = board.length;
        int n = board[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {  // make sure not out of bound
            return;
        }

        if (visited[i][j]) {  // make sure not visited
            return;
        }

        word += board[i][j];

        if (!dictionary.startWith(word)) {
            return;
        }
        if (dictionary.search(word)) {
            result.add(word);
        }

        // already visited i, j
        visited[i][j] = true;

        dfs (board, visited, word, i - 1, j, dictionary);
        dfs (board, visited, word, i + 1, j, dictionary);
        dfs (board, visited, word, i, j - 1, dictionary);
        dfs (board, visited, word, i, j + 1, dictionary);

        visited[i][j] = false;   // not we have a new start point, set visited[i][j] to be false
    }

    public List<String> findWords(char[][] board, String[] words) {
        // set up a trie tree to store words
        Trie dictionary = new Trie();
        for (int i = 0; i < words.length; i++) {
            dictionary.addWord(words[i]);
        }

        // get the board dimension
        int m = board.length;
        int n = board[0].length;

        // initialize visited
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs (board, visited, "", i, j, dictionary);
            }
        }

        return new ArrayList<String>(result);
    }

    public static void main(String[] args) {
        char[][] board = {
                {'a', 'a'}
        };
        String[] words = {"a"};
        LC212WordSearchII l = new LC212WordSearchII();
        System.out.println(l.findWords(board, words));
    }
}