//GFG
//Total Cuts
//Time complexity: O(N)
//Space complexity: O(N)

package GFG;

public class TotalCuts {

    public static void main(String[] args) {
        int N = 3;
        int K = 3;
        int A[] = { 1, 2, 3 };
        System.out.println(totalCuts(N, K, A));
    }

    public static int totalCuts(int N, int K, int[] A) {
        // code here
        int right[]=new int[N];
        int left[]=new int[N];
        left[0]=A[0]; right[N-1]=A[N-1];

        for(int i=1;i<N;i++)
            left[i]=Math.max(left[i-1],A[i]);

        
        for(int i=N-2;i>=0;i--)
            right[i]=Math.min(right[i+1],A[i]);

        int ans=0;
        for(int i=0;i<N-1;i++){
            if(left[i]+right[i+1]>=K){
                ans++;
            }
        }
        return ans;
    }
}
