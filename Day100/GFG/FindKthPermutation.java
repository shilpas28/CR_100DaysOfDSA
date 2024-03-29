//GFG
//Find Kth Permutation
//Time complexity: O(N^2)
//Space complexity: O(N)

package GFG;

import java.util.Arrays;


public class FindKthPermutation {

	public static void main(String[] args) {
		int N = 4, K = 3;
		System.out.println(kthPermutation(N, K));
	}

	public static String kthPermutation(int n, int k) {
		// code here
		int fact[] = new int[n + 1];
		Arrays.fill(fact, 1);
		for (int i = 1; i <= n; i++) fact[i] = i * fact[i - 1];
		boolean vis[] = new boolean[n + 1];
		Arrays.fill(vis, false);
		StringBuilder ans = new StringBuilder();
		int i = n;
		while (ans.length() != n) {
			int row = k / fact[i - 1];
			if (k % fact[i - 1] != 0) row++;
			for (int j = 1; j <= n; j++) {
				if (vis[j] == false) {
					row--;
				}
				if (row == 0) {
					vis[j] = true;
					char a = (char)(j + '0');
					ans.append(a);
					break;
				}
			}
			k = k % fact[i - 1];
			if (k == 0) k = fact[i - 1];
			i--;
		}
		return ans.toString();
	}
}