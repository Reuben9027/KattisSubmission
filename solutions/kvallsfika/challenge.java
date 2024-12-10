import java.io.*;
import java.math.BigInteger;
//import java.io.InputStreamReader;
import java.util.*;

class Food {
    long price;
    int type;

    Food(long p) {
        price = p;
    }
}

class Comp implements Comparator<Food> {

    @Override
    public int compare(Food o1, Food o2) {
        return Long.compare(o1.price, o2.price);
    }

}

public class challenge {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long p = Long.parseLong(br.readLine());
        int k = Integer.parseInt(br.readLine());

        ArrayList<Food> list = new ArrayList<>();

        StringTokenizer strTok = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            long temp = Long.parseLong(strTok.nextToken());
            list.add(new Food(temp));
        }

        strTok = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(strTok.nextToken());
            list.get(i).type = temp;
        }

        list.sort(new Comp());

        int arr[] = new int[100001];
        int r = 0;
        for (Food f : list) {
            int fT = f.type;
            if (arr[fT] >= k) {
                continue;
            }

            p -= f.price;
            if (p < 0) {
                break;
            }
            r++;
            arr[fT]++;
        }
        System.out.println(r);
    }
}
