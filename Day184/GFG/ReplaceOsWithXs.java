//GFG
//Replace O's with X's
//Time complexity: O(n*m)
//Space complexity: O(n*m)

public class ReplaceOsWithXs {

    public static void main(String[] args) {
        int n = 5, m = 4;
        char[][] mat = { { 'X', 'X', 'X', 'X' },
                { 'X', 'O', 'X', 'X' },
                { 'X', 'O', 'O', 'X' },
                { 'X', 'O', 'X', 'X' },
                { 'X', 'X', 'O', 'O' } };
        char[][] res = fill(n, m, mat);
        for (char[] row : res) {
            for (char val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    static char[][] fill(int n, int m, char a[][]) {
        // code here
        for (int i = 0; i < n; i++) {
            if (a[i][0] == 'O') // 1st col
                dfs(a, i, 0, 'O', '-', n, m);

            if (a[i][m - 1] == 'O') // last col
                dfs(a, i, m - 1, 'O', '-', n, m);
        }

        for (int i = 0; i < m; i++) {
            if (a[0][i] == 'O') // 1st row
                dfs(a, 0, i, 'O', '-', n, m);
            if (a[n - 1][i] == 'O') // last row
                dfs(a, n - 1, i, 'O', '-', n, m);
        }

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (a[i][j] == 'O')
                    a[i][j] = 'X';

        // change - to X;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (a[i][j] == '-')
                    a[i][j] = 'O';

        return a;
    }

    static void dfs(char a[][], int x, int y,
            char prevC, char newC, int N, int M) {
        // out of bound
        if (x < 0 || x >= N || y < 0 || y >= M)
            return;
        if (a[x][y] != prevC)
            return;

        // mark with newC and itr in 4 neighbours
        a[x][y] = newC;
        dfs(a, x + 1, y, prevC, newC, N, M);
        dfs(a, x - 1, y, prevC, newC, N, M);
        dfs(a, x, y + 1, prevC, newC, N, M);
        dfs(a, x, y - 1, prevC, newC, N, M);
    }
}
