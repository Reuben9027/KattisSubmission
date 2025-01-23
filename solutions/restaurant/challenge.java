import java.util.*;
import java.lang.*;
import java.io.*;

public class challenge {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner s = new Scanner(System.in);
        while (true) {
            int n = s.nextInt();
            if (n == 0) {
                break;
            }

            long p1 = 0;
            long p2 = 0;
            for (int i = 0; i < n; i++) {
                String k = s.next();
                long p = s.nextLong();
                if (k.equals("DROP")) {
                    p2 += p;
                    System.out.println("DROP 2 " + p);
                } else {
                    long min = Math.min(p1, p);
                    long temp = Math.abs(p1 - p);
                    if (min == p) {
                        System.out.println("TAKE 1 " + p);
                        p1 -= p;
                        continue;
                    }

                    if (p1 != 0) {
                        System.out.println("TAKE 1 " + p1);
                        p1 = 0;
                    }
                    System.out.println("MOVE 2->1 " + p2);
                    p1 += p2;
                    p2 = 0;
                    p1 -= temp;
                    System.out.println("TAKE 1 " + temp);

                }
            }
            System.out.println();

        }
    }
}
