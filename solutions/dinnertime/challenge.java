import java.util.*;

public class challenge {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        long p = 0;
        long g = 0;
        long r = 0;
        for (int i = 0; i < n; i++) {
            String k = s.next();
            long temp = s.nextLong();
            if (k.charAt(0) == 'G') {
                long h = Math.max(Math.min((p - g), temp), 0);
                r += h;
                g += temp;
                if (r == 0) {
                    r = 1;
                }
            } else {
                if (p + temp >= g && p < g) {
                    r += 1;
                }
                if (r == 0) {
                    r = 1;
                }
                p += temp;
            }
        }
        System.out.println(r);

    }
}