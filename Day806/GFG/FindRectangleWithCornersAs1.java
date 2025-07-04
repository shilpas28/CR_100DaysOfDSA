//GFG
//Find rectangle with corners as 1
//Time complexity: O(n * (m^2))
//Space complexity: O(n)

public class FindRectangleWithCornersAs1 {

    public static void main(String[] args) {
        int mat[][] = { { 1, 0, 0, 1, 0 },
                { 0, 0, 1, 0, 1 },
                { 0, 0, 0, 1, 0 },
                { 1, 0, 1, 0, 1 } };
        System.out.println(ValidCorner(mat));
    }

    public static boolean ValidCorner(int mat[][]) {
        // Code here
        int m = mat.length;
        int n = mat[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    int r = i;
                    int c = j;

                    for (int k = j + 1; k < n; k++) {
                        if (mat[r][k] == 1) {
                            for (int p = r + 1; p < m; p++) {
                                if (mat[p][c] == 1 && mat[p][k] == 1) {
                                    return true;
                                }
                            }
                        }
                    }
                }

            }
        }
        return false;
    }
}
