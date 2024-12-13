import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

class challenge {
    public static void main(String[] args) throws java.lang.Exception {
        /// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner s = new Scanner(System.in);

        StringBuilder strb = new StringBuilder(s.next());
        String k = s.next();
        int n = k.length();
        for (int i = 0; i < n; i++) {
            try {
                if (strb.charAt(0) == k.charAt(i)) {
                    strb.replace(0, 1, "");
                }
            } catch (Exception e) {
                break;
            }
        }

        System.out.println(strb.length() == 0 ? "Ja" : "Nej");

    }
}
