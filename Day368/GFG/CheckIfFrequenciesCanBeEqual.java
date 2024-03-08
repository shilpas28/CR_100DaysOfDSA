//GFG
//Check if frequencies can be equal
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

import java.util.HashMap;
import java.util.Map;

public class CheckIfFrequenciesCanBeEqual {

    public static void main(String[] args) {
        String s = "xyyz";
        System.out.println(sameFreq(s));
    }

    static boolean sameFreq(String s) {
        // code here
        HashMap<Character, Integer> mm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            mm.put(s.charAt(i), mm.getOrDefault(s.charAt(i), 0) + 1);
        }
        int mn = Integer.MAX_VALUE, mx = Integer.MIN_VALUE, mxCount = 0, mnCount = 0;
        for (Map.Entry<Character, Integer> x : mm.entrySet()) {
            mn = Math.min(mn, x.getValue());
            mx = Math.max(mx, x.getValue());
        }
        for (Map.Entry<Character, Integer> x : mm.entrySet()) {
            if (x.getValue() == mx)
                mxCount++;
            else if (x.getValue() == mn)
                mnCount++;
        }
        if (mn == mx - 1 && mxCount == 1 || (mn == mx))
            return true;
        if (mnCount == 1 && mn == 1 && mxCount + mnCount == mm.size())
            return true;
        return false;
    }
}
