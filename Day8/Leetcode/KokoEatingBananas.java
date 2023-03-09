//875. Koko Eating Bananas
//Leetcode
//Time complexity: O(N*logN)
//Space complexity: O(1)


package Day8.Leetcode;

public class KokoEatingBananas {
    
    public static void main(String[] args) {
        int[] piles = {805306368,805306368,805306368};
        int h = 1000000000;
        System.out.println(minEatingSpeed(piles, h));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        // int right = 1000000000;
        int right = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) {
            right = Math.max(right, piles[i]);
        }
        
        while(left < right){
            int mid = left + (right - left) / 2;
            if(canEatInTime(piles, mid, h)) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    public static boolean canEatInTime(int piles[], int k, int h){
        int hours = 0;
        for(int pile : piles){
            int div = pile / k;
            hours += div;
            if(pile % k != 0) hours++;
        }
        return hours <= h;
    }
}
