import java.util.*;

public class challenge {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int k = s.nextInt();

        int r = 0;
        int h = Math.min(n, k);
        r += 10 * h;
        n -= h;

        r += (int) (n / 3) * 10;
        n %= 3;

        r += (int) (n / 2) * 3;
        n %= 2;

        r += (int) (n / 1);
        n %= 1;

        System.out.println(r);

    }
}
