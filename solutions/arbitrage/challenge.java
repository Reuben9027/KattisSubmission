import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Exchange {
    Curr c1;
    Curr c2;
    double change;

    Exchange(Curr c1, Curr c2, double change) {
        this.c1 = c1;
        this.c1.list.add(this);

        this.c2 = c2;
        this.change = change;
    }
}

class Curr {
    ArrayList<Exchange> list = new ArrayList<>();
}

public class challenge {
    static HashMap<Curr, Double> hash = new HashMap<>();

    static boolean solve(Curr c, double money) {
        if (hash.containsKey(c)) {
            double temp = hash.get(c);
            return temp < money;
        }
        hash.put(c, money);
        boolean k = false;
        for (Exchange temp : c.list) {
            double value = temp.change * money;
            k |= solve(temp.c2, value);
            if (k) {
                return true;
            }
        }
        hash.remove(c);

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        outer: while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            HashMap<String, Curr> hash2 = new HashMap<>();

            StringTokenizer strTok = new StringTokenizer(br.readLine(), " ");
            while (strTok.hasMoreTokens()) {
                hash2.put(strTok.nextToken(), new Curr());
            }

            int k = Integer.parseInt(br.readLine());
            for (int i = 0; i < k; i++) {
                strTok = new StringTokenizer(br.readLine(), " ");
                Curr a = hash2.get(strTok.nextToken());
                Curr b = hash2.get(strTok.nextToken());

                String[] p = strTok.nextToken().split(":");
                double ratio = Double.parseDouble(p[1]) / Double.parseDouble(p[0]);
                Exchange ex = new Exchange(a, b, ratio);
            }

            Collection<Curr> col = hash2.values();
            for (Curr temp : col) {
                if (solve(temp, 1)) {
                    System.out.println("Arbitrage");
                    continue outer;
                }
            }
            System.out.println("Ok");

        }
    }
}
