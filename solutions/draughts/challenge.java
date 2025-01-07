import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class challenge {
    static char[][] arr = new char[10][10];

    public static int solve(int x, int y) {
        try {
            if (arr[y][x] != '#') {
                return 0;
            }
            int r = 0;
            for (int i = -1; i <= 1; i++) {
                for (int o = -1; o <= 1; o++) {
                    try {
                        if (i == 0 || o == 0) {
                            continue;
                        }
                        if (arr[y + i][x + o] == 'B') {
                            // arr[y][x] = '#';
                            arr[y + i][x + o] = '#';
                            r = Math.max(r, solve(x + (2 * o), y + (2 * i)));
                            // arr[y][x] = 'W';
                            arr[y + i][x + o] = 'B';
                        }
                    } catch (Exception e) {
                        continue;
                    }
                }
            }
            return r + 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int n = 10;

        int t = s.nextInt();

        while (t-- > 0) {
            for (int i = 0; i < n; i++) {
                arr[i] = s.next().toCharArray();
            }

            int r = 0;
            for (int i = 0; i < n; i++) {
                for (int o = 0; o < n; o++) {
                    if (arr[i][o] == 'W') {
                        arr[i][o] = '#';
                        r = Math.max(solve(o, i) - 1, r);
                        arr[i][o] = 'W';
                    }
                }
            }
            System.out.println(r);
        }
    }
}
