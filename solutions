import java.io.*;
//import java.io.InputStreamReader;
import java.util.*;

class IntS {
    int val = 0;

    IntS(int val) {
        this.val = val;
    }
}

public class challenge {
    public static void main(String[] args) throws IOException {
        // Scanner s = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> hash = new HashMap<>();

        StringTokenizer strTok = new StringTokenizer(br.readLine(), " ");

        int r = 0;
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(strTok.nextToken());
            if (!hash.containsKey(temp + 1) || hash.get(temp+1) <=0) {
                r++;
                if (!hash.containsKey(temp)) {
                    hash.put(temp, 0);
                }
                hash.put(temp, hash.get(temp) + 1);
                continue;
            }
            // if (hash.get(temp + 1) <= 0) {
            // r++;
            // hash.put(temp, hash.get(temp) + 1);
            // continue;
            // }

            int k = hash.get(temp + 1);
            hash.put(temp + 1, k - 1);

            if (!hash.containsKey(temp)) {
                hash.put(temp, 0);
            }
            hash.put(temp, hash.get(temp) + 1);
        }
        System.out.println(r);
    }
}