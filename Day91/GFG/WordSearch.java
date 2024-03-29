//GFG
//Word Search
//Time complexity: O(N * M * 4L) where N = No. of rows in board, M = No. of columns in board, L = Length of word
//Space complexity: O(L), L is length of word.

package GFG;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = { { 'a', 'g', 'b', 'c' }, { 'q', 'e', 'e', 'l' }, { 'g', 'b', 'k', 's' } };
        String word = "geeks";
        System.out.println(isWordExist(board, word));
    }

    public static boolean isWordExist(char[][] board, String word) {
        // Code here
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && help(board, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    static boolean help(char[][] b, String w, int i, int j, int len) {
        if (len == w.length()) // if reached the word end
            return true;
        if (i < 0 || j < 0 || i >= b.length || j >= b[0].length) // if went oob
            return false;
        if (b[i][j] != w.charAt(len)) // the dir in which we moved does not have matching ch.
            return false;
        // character mactches, mark it and recur for all 4 dir for next ch.
        b[i][j] = '*'; // mark it vis so that it cannot take the same ch again in path.
        return help(b, w, i - 1, j, len + 1) || // up
                help(b, w, i + 1, j, len + 1) || // down
                help(b, w, i, j - 1, len + 1) || // left
                help(b, w, i, j + 1, len + 1); // right
    }
}
