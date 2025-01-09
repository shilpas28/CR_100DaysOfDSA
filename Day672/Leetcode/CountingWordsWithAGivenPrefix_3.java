//Leetcode
//2185. Counting Words With a Given Prefix - Trie 
//Time complexity: O((n*l)+m)
//Space complexity: O(n*l)

public class CountingWordsWithAGivenPrefix_3 {

    public static void main(String[] args) {
        String[] words = { "pay", "attention", "practice", "attend" };
        String pref = "at";
        System.out.println(prefixCount(words, pref));
    }

    static class Trie {

        // Node class represents each character in Trie
        class Node {
            // Links to child nodes
            Node[] links;
            // Number of strings having prefix till this node
            int count;

            Node() {
                // For lowercase English letters
                links = new Node[26];
                count = 0;
            }
        }

        Node root;

        Trie() {
            root = new Node();
        }

        // Add word to trie and update prefix counts
        public void addWord(String word) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (curr.links[c - 'a'] == null) {
                    curr.links[c - 'a'] = new Node();
                }
                curr = curr.links[c - 'a'];
                curr.count++; // Increment count for this prefix
            }
        }

        // Return count of strings having pref as prefix
        public int countPrefix(String pref) {
            Node curr = root;
            for (int i = 0; i < pref.length(); i++) {
                char c = pref.charAt(i);
                if (curr.links[c - 'a'] == null) {
                    return 0; // Prefix not found
                }
                curr = curr.links[c - 'a'];
            }
            return curr.count; // Return count at last node
        }
    }

    public static int prefixCount(String[] words, String pref) {
        Trie trie = new Trie();
        // Add all words to trie
        for (String word : words) {
            trie.addWord(word);
        }
        return trie.countPrefix(pref);
    }
}
