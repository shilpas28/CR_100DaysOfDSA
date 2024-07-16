//GFG
//Remaining String
//Time complexity: O(|s|)
//Space complexity: O(1)

public class RemainingString {

    public static void main(String[] args) {
        String s = "Thisisdemostring";
        char ch = 'i';
        int count = 3;
        System.out.println(printString(s, ch, count));
    }

    public static String printString(String s, char ch, int count) {
        // code here
        int i = 0;
        for (i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch)
                count--;
            if (count == 0)
                break;
        }
        if (i >= s.length() - 1)
            return "";
        s = s.substring(i + 1);
        return s;
    }
}
