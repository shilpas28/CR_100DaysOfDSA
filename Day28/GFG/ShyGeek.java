//GFG - using Binary Search
//Shy Geek
//Time complexity: O(logN)
//Space complexity: O(logN)

package GFG;

public class ShyGeek {

    public static void main(String[] args) {

    }

    // static Shop shop;

    // ShyGeek(Shop shop) {
    //     this.shop = shop;
    // }

    // static long find(int n, long k) {
    //     // Return the number of chocolates Geek had
    //     // enjoyed out of 'n' chocolates availabe in the
    //     // 'shop'.
    //     if (k == 0)
    //         return 0;
    //     long ans = 0;
    //     long[] binarysearch = BinarySearch(n, k);
    //     int mid = (int) binarysearch[1];
    //     long price = binarysearch[0];
    //     if (price == k)
    //         return 1;

    //     if (price == -1)
    //         return 0;
    //     if (price > k && mid > 0) {
    //         int price2 = shop.get(mid - 1);
    //         ans += (k / price2);
    //         k = k % price2;
    //     } else if (price < k) {
    //         ans += (k / price);
    //         k = k % price;
    //     }
    //     return ans + find(mid, k);
    // }

    // static long[] BinarySearch(int n, long k) {
    //     long ans = 0;
    //     int low = 0, high = n - 1;
    //     long price = -1;
    //     int mid = -1;
    //     while (low <= high) {
    //         mid = (low + high) / 2;
    //         price = shop.get(mid);

    //         if (price == k) {
    //             return new long[] { price, (long) (mid) };
    //         } else if (price < k) {
    //             low = mid + 1;
    //         } else {
    //             high = mid - 1;
    //         }
    //     }
    //     return new long[] { price, (long) (mid) };
    // }
}
