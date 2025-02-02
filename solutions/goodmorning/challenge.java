import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

public class challenge {
    static HashSet<Integer> hash = new HashSet<>();
    static ArrayList<Integer> list = new ArrayList<>();
    static int[][] arr = new int[4][3];

    static void solve(int x, int y, int c) {
        try {
            int r = (c * 10) + (arr[y][x]);
            if (hash.contains(r) || arr[y][x] == -1 || r > 200) {
                return;
            }
            list.add(r);
            hash.add(r);
            solve(x + 1, y, r);
            solve(x, y + 1, r);
            solve(x + 1, y, c);
            solve(x, y + 1, c);

            solve(x + 1, y + 1, r);
            solve(x + 1, y + 1, c);

            solve(x, y, r);
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int c = 0;
        for (int i = 0; i < 3; i++) {
            for (int o = 0; o < 3; o++) {
                arr[i][o] = ++c;
            }
        }
        arr[3][0] = -1;
        arr[3][2] = -1;

        solve(0, 0, 0);
        list.sort(null);

        int t = s.nextInt();
        while (t-- > 0) {

            int k = s.nextInt();
            int l = 0;
            int r = list.size() - 1;
            if (hash.contains(k)) {
                System.out.println(k);
                continue;
            }
            while (l + 1 < r) {
                int mid = (((r - l) / 2) + l);
                int j = (list.get(mid) - k);
                if (j < 0) {
                    l = mid;
                } else {
                    r = mid;
                }
            }
            int n1 = Math.abs(list.get(l) - k);
            int n2 = Math.abs(list.get(r) - k);
            System.out.println(n1 < n2 ? list.get(l) : list.get(r));

        }
    }
}