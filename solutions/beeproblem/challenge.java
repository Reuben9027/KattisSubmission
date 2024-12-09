import java.util.*;

public class challenge {
    static boolean[][] arr;

    static int solve(int x, int y) {
        try {
            if (arr[y][x]) {
                return 0;
            }
            arr[y][x] = true;
            int r = 1;
            r += solve(x + 1, y);
            r += solve(x - 1, y);
            r += solve(x, y + 1);
            r += solve(x, y - 1);

            if (y % 2 == 0) {

                r += solve(x - 1, y - 1);
                r += solve(x - 1, y + 1);
            } else {

                r += solve(x + 1, y - 1);
                r += solve(x + 1, y + 1);
            }
            return r;
        } catch (Exception e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int h = s.nextInt();
        int n = s.nextInt();
        int m = s.nextInt();
        s.nextLine();

        if (h == 0) {
            System.out.println(0);
            return;
        }
        arr = new boolean[n][m];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer strTok = new StringTokenizer(s.nextLine(), " ");
            for (int o = 0; o < m; o++) {
                arr[i][o] = strTok.nextToken().charAt(0) == '#';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int o = 0; o < m; o++) {
                int v = solve(o, i);
                if (v != 0) {
                    list.add(v);
                }
            }
        }
        list.sort(Comparator.reverseOrder());
        for (int i = 0; i < list.size(); i++) {
            int v = list.get(i);
            h -= v;
            if (h <= 0) {
                System.out.println(i + 1);
                return;
            }
        }
        System.out.println(-1);
    }
}