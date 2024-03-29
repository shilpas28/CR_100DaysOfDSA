//GFG
//Panagram Checking
//Time complexity:  O(|s|)
//Space complexity: O(1)

package GFG;

import java.util.HashMap;
import java.util.Map;

public class PanagramChecking_4 {

    public static void main(String[] args) {
        String s = "Bawds jog, flick quartz, vex nymph";
        System.out.println(checkPangram(s));
    }

    // Function to check if a string is Pangram or not.
    public static boolean checkPangram(String s) {
        // your code here
        if (s.length() < 26)
            return false;
        Map<Integer, Integer> mm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            if (x >= 'A' && x <= 'Z') {
                mm.putIfAbsent(x - 'A', 1);
            } else if (x >= 'a' && x <= 'z') {
                mm.putIfAbsent(x - 'a', 1);
            }
        }
        return mm.size() == 26;
    }
}
