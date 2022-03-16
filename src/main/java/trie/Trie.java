package trie;

public class Trie {

    static final int ALPHABET_SIZE = 26;

    static class TrieNode {

        TrieNode[] children = new TrieNode[ALPHABET_SIZE];

        boolean endOfWord;

        TrieNode () {
            endOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                children[i] = null;
            }
        }
    }

    static TrieNode root;

    static void insert(String key) {

        int length = key.length();
        int index;

        TrieNode pCrawl = root;

        for(int i=0; i<length; i++) {
            index = key.charAt(i) - 'a';

            if(pCrawl.children[index] == null) {
                pCrawl.children[index] = new TrieNode();
            }

            pCrawl = pCrawl.children[index];
        }
        pCrawl.endOfWord = true;
    }

    static boolean search(String key) {

        int length = key.length();
        int index;

        TrieNode pCrawl = root;
        for(int i=0; i<length; i++) {
            index = key.charAt(i) - 'a';

            if(pCrawl.children[index] == null) {
                return false;
            }
            pCrawl = pCrawl.children[index];
        }
        return pCrawl.endOfWord;
    }
}
