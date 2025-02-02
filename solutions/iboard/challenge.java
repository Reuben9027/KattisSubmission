import java.util.*;
import java.lang.*;
import java.security.GuardedObject;
import java.io.*;

class Char {
    int left = 0;
    int right = 0;

    int rightExtra = 0;

    Char(char c) {
        int p = (int) c;
        for (int i = 0; i < 7; i++) {
            int k = (p >>> i);
            int j = k & 1;
            if (j == 1) {
                left++;
            } else {
                right++;
                rightExtra += k == 0 ? 1 : 0;
            }
        }
    }
}

public class challenge {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner s = new Scanner(System.in);
        HashMap<Character, Char> hash = new HashMap<>();
        while (s.hasNextLine()) {
            String k = s.nextLine();
            int left = 0;
            int right = 0;
            int n = k.length() ;
            for (int i = 0; i < n; i++) {
                char c = k.charAt(i);
                if (!hash.containsKey(k)) {
                    hash.put(c, new Char(c));
                }
                Char temp = hash.get(c);
                left += temp.left;
                left %= 2;
                right += temp.right;
                right %= 2;
            }
            System.out.println(left == 0 && right == 0 ? "free" : "trapped");

        }
    }
}
