import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class challenge {

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        char[][] arr = new char[5][5];

        boolean hash[] = new boolean[256];
        int hash2[][] = new int[256][];

        String k = s.nextLine().replace(" ", "");
        String p = s.nextLine().replace(" ", "");

        hash['0'] = true;
        hash['q'] = true;
        int counter = 0;
        char counter2 = 'a';

        for (int i = 0; i < 5; i++) {
            for (int o = 0; o < 5; o++) {
                char c = '0';
                try {
                    c = k.charAt(counter++);
                    if (hash[c]) {
                        o--;
                        continue;
                    }
                } catch (Exception e) {
                    while (hash[c]) {
                        c = counter2++;
                    }
                }
                arr[i][o] = c;

                hash2[c] = new int[2];
                hash2[c][0] = i;
                hash2[c][1] = o;
                hash[c] = true;
            }
        }

        // for (int i = 0; i < 5; i++) {
        //     for (int o = 0; o < 5; o++) {
        //         System.out.print(arr[i][o]);
        //     }
        //     System.out.println();
        // }
        String r = "";

        int n = p.length();
        for (int i = 0; i < n; i += 2) {
            char a, b;
            a = p.charAt(i);
            try {
                b = p.charAt(i + 1);
            } catch (Exception e) {
                b = 'x';
            }
            if (a == b) {
                b = 'x';
                i--;
            }

            try {
                int indA[] = hash2[a];
                int indB[] = hash2[b];
                if (indA[0] == indB[0]) {
                    r += arr[indA[0]][(indA[1] + 1) % 5];
                    r += arr[indB[0]][(indB[1] + 1) % 5];
                    continue;
                }

                if (indA[1] == indB[1]) {
                    r += arr[(indA[0] + 1) % 5][indA[1]];
                    r += arr[(indB[0] + 1) % 5][indB[1]];
                    continue;
                }

                r += arr[indA[0]][indB[1]];
                r += arr[indB[0]][indA[1]];
            } catch (Exception e) {
                r += a;
                r += b;
            }
        }
        System.out.println(r.toUpperCase());

    }
}
