import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class challenge {
    static char arr[][];
    static char hash[] = new char[256];
    static char kArr[][];

    static boolean check(char c, int x, int y) {
        try {
            char p = arr[y][x];
            if (hash[c] == p) {
                kArr[y][x] = c;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    static void solve(int x, int y) {
        char c = arr[y][x];
        check(c, x - 1, y);
        check(c, x + 1, y);

        check(c, x, y - 1);
        check(c, x, y + 1);
    }

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        hash['R'] = 'S';
        hash['P'] = 'R';
        hash['S'] = 'P';
        int t = s.nextInt();

        while (t-- > 0) {
            int n = s.nextInt();
            int k = s.nextInt();
            int d = s.nextInt();
            arr = new char[n][k];
            kArr = new char[n][k];
            for (int i = 0; i < n; i++) {
                arr[i] = s.next().toCharArray();
            }

            while (d-- > 0) {
                for (int i = 0; i < n; i++) {
                    for (int o = 0; o < k; o++) {
                        solve(o, i);
                    }
                }
                for (int i = 0; i < n; i++) {
                    for (int o = 0; o < k; o++) {
                        char c = kArr[i][o];
                        if (c != '\0') {
                            arr[i][o] = c;
                        }

                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int o = 0; o < k; o++) {
                    System.out.print(arr[i][o]);
                }
                System.out.println();
            }
            System.out.println();

        }
    }
}
