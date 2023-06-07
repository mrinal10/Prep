package dsalgo.leetcode.bfs;

import java.util.*;

class Leetcode127 {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet();
        for(String s : wordList){
            set.add(s);
        }
        if(!set.contains(endWord)) {
            return 0;
        }

        Queue<String> q = new LinkedList<String>();
        q.offer(beginWord);
        int level = 1;
        while(!q.isEmpty()) {
            int sizeOfQ = q.size();
            for(int j=0; j<sizeOfQ; j++) {
                char[] ar = q.poll().toCharArray();
                for(int i=0; i<ar.length; i++) {
                    char originalChar = ar[i];
                    for(char c = 'a'; c<='z'; c++) {
                        ar[i] = c;
                        String currentWord = String.valueOf(ar);
                        if(!set.contains(currentWord) || currentWord.equals(beginWord))
                            continue;
                        else if(currentWord.equals(endWord)) {
                            return level+1;
                        }
                        q.offer(currentWord);
                        set.remove(currentWord);
                    }
                    ar[i] = originalChar;
                }
            }
            level++;
        }
        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = null;// List.of("hot","dot","dog","lot","log","cog");

        System.out.println(ladderLength(beginWord, endWord, wordList));
    }
}