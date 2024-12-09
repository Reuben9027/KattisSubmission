import java.util.*;

public class challenge {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String k = s.next();
        String p = s.next();
        int arr[] = new int[256];
        int n = 5;
        for (int i = 0; i < n; i++) {
            arr[k.charAt(i)] += 1;
        }

        char r[] = new char[5];
        Arrays.fill(r, '-');
        for (int i = 0; i < n; i++) {
            char c1 = k.charAt(i);
            char c2 = p.charAt(i);
            if (c1 == c2) {
                r[i] = 'G';
                arr[c1] -= 1;
            }
        }
        for (int i = 0; i < n; i++) {
            char c1 = k.charAt(i);
            char c2 = p.charAt(i);
            if (c1 != c2 && arr[c2] > 0) {
                r[i] = 'Y';
                arr[c2] -= 1;
            }
        }
        System.out.println(new String(r));
    }
}