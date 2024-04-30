/*
* A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a
* dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

* Trie() Initializes the trie object.
* void insert(String word) Inserts the string word into the trie.
* boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
* boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix, and false otherwise.

* */

package Trees;

import java.util.HashMap;

class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    static class TrieNode{
        HashMap<Character, TrieNode> children;
        boolean endOfWord;

        public TrieNode(){
            children = new HashMap<>(26);
            endOfWord = false;
        }
    }

    public void insert(String word) {

        TrieNode curr = root;

        char[] charArray = word.toCharArray();

        for(char c: charArray){
            HashMap<Character,TrieNode> childrenHM = curr.children;
            if(childrenHM.get(c) == null){
                childrenHM.put(c, new TrieNode());
            }
            curr = childrenHM.get(c);
        }

        curr.endOfWord = true;
    }

    public boolean search(String word) {

        TrieNode curr = root;

        char[] charArray = word.toCharArray();

        for(char c: charArray){
            HashMap<Character,TrieNode> childrenHM = curr.children;
            if(childrenHM.get(c) == null){
                return false;
            }
            curr = childrenHM.get(c);
        }
        return curr.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;

        char[] charArray = prefix.toCharArray();

        for(char c: charArray){
            HashMap<Character,TrieNode> childrenHM = curr.children;
            if(childrenHM.get(c) == null){
                return false;
            }
            curr = childrenHM.get(c);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */