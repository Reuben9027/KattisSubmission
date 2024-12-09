
import java.io.*;
import java.util.*;

public class challenge {

    public static void main(String[] arhs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Long> left = new Stack<>();
        Stack<Long> right = new Stack<>();
        int n = Integer.parseInt(br.readLine()) * 2;

        StringTokenizer strTok = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            left.add(Long.parseLong(strTok.nextToken()));
        }

        int r = 0;
        while (!left.isEmpty()) {
            r++;
            try {
                long valTopLeft = left.peek();
                long valTopRight = right.peek();
                if (valTopLeft == valTopRight) {
                    left.pop();
                    right.pop();
                    continue;
                }
                right.add(left.pop());
            } catch (Exception e) {
                right.add(left.pop());
            }
        }

        System.out.println(right.isEmpty() ? r : "impossible");

    }
}
