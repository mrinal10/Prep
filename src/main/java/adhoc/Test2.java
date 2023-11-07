package adhoc;

import com.fasterxml.uuid.Generators;
import java.math.BigInteger;

public class Test2 {
    static class SuffixTrieNode {
        static final int MAX_CHAR = 26;
        SuffixTrieNode[] children = new SuffixTrieNode[MAX_CHAR];
  
        SuffixTrieNode(){
            for (int i = 0; i < MAX_CHAR; i++)
                children[i] = null;
        }
  
        void insertSuffix(String s) {
            if (s.length() > 0) {
                char cIndex = (char) (s.charAt(0) - 'a');
  
                if (children[cIndex] == null) {
                    children[cIndex] = new SuffixTrieNode();
                }
                children[cIndex].insertSuffix(s.substring(1));
            }
        }
    }
      
    static class Suffix_trie {
        static final int MAX_CHAR = 26;
        SuffixTrieNode root;
  
        Suffix_trie(String s) {
            root = new SuffixTrieNode();
            for (int i = 0; i < s.length(); i++)
                root.insertSuffix(s.substring(i));
        }
  
        int _countNodesInTrie(SuffixTrieNode node) {
            if (node == null)
                return 0;
  
            int count = 0;
            for (int i = 0; i < MAX_CHAR; i++) {
                if (node.children[i] != null)
                    count += _countNodesInTrie(node.children[i]);
            }
            return (1 + count);
        }
  
        int countNodesInTrie() {
            return _countNodesInTrie(root);
        }
  
    } 
  
    public static long substringCalculator(String s) {
        Suffix_trie sTrie = new Suffix_trie(s);
  
        return sTrie.countNodesInTrie();
    }

    static class Node {
        Node links[] = new Node[26];

        boolean containsKey(char ch) {
            return (links[ch - 'a'] != null);
        }

        Node get(char ch) {
            return links[ch - 'a'];
        }

        void put(char ch, Node node) {
            links[ch - 'a'] = node;
        }
    }
    
    public static int countDistinctSubstrings(String s) {
        Node root = new Node();
        int n = s.length();
        int count = 0;
    
        for (int i = 0; i < n; i++) {
            Node node = root;

            for (int j = i; j < n; j++) {
                if (!node.containsKey(s.charAt(j))) {
                    node.put(s.charAt(j), new Node());
                    count++;
                }
                node = node.get(s.charAt(j));
            }
        }
        return count + 1;
    }
    
    
    public static void main(String[] args) {
       /* String s = String.valueOf(Generators.timeBasedGenerator().generate().toString().replace("-", ""));
        BigInteger bInt = new BigInteger(s, 16);
        System.out.println(bInt);
        //String.format("%040d", new BigInteger(Generators.timeBasedGenerator().generate().toString().replace("-", ""), 12));
        System.out.println(s + " :: " + s.length());*/

        long n = Test2.substringCalculator("kincenvizh");
            //"ghaqjdrmnegmrlrlfpjmnnngpwalzknsencuzwsnhfltwohdgbmvfuwtquosrnyerucntxxkfqehjqygcarxogvcfkljzbzutxphpyykapncjfclnhndzxghelyvzpylazhuutmcquusexzbhsfsmbnlvnlemzvfqbfzwquairhpylnbvyhiyamztlhfchhbwrqddmuzsprfdwuqqchcpeakkexackwwzihkfenwzwckynymgqydvjtovaoezkjjurylqcuonsujycziobnfnmuwnoxcdtahpituykvgpyyshvukrstcbmnsqtjseflwywnslmvnqrtnzkyaddkjamrezprqgoenzsdryygbkeahfiduozpwkrgmatszaxmwodsqiocvagbvxyqotpaujnqvqgjmfxnxhfbwqjpgodlxdrxpjpmzeabpgqrzpxomniknjkdiwtfgyvwvekrnoupwkcbtmpcfamzrghgrznuedkybmfwctdghcfawajlxfkzhdamuygjbcwnyglkjlfmpxfdtovkqbshhrfrnyjrgxgiozsuuncnwofkqzsypwgeikpfbhryhpszegdfajzvqlwwqlnvdtdiuckcvvosrdweohnmawqonjbxyjjhlccuteeshfrxxdhzgakwjqbymnaeudcmibsytyajsgdpfvrutcpglzxdevenevmkgalcrpknuvcrnkuboennhyzirfwvtozzijujsckbxqpocakzrbwgpqgjjmsrtwmvhwyraukbuxfvebeylfpipzwjdzlmgslbtwzataxgqpasrssnfwndldwkdutdqcmcpyanrbdsxrvcvpsywjambtbzlcrvzesuhvyvwwuwwdznigxjxknfajpknqutfvvqynkpvkzgypasevrpxofbymdzcitoqolwqegocuyqsexhumzmckzuuwkamolbltlifongpvkcnrnnuplftqbxpdnegdqlymftqyrxcnzmu");

        System.out.println(n - 1);
    }
}
