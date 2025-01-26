import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class embarrassedcryptographer {
    static boolean[] arr = new boolean[10000001];

    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws java.lang.Exception {
        Scanner s = new Scanner(System.in);
        arr[0] = true;
        arr[1] = true;

        for (int i = 2; i < arr.length; i++) {
            if (arr[i]) {
                continue;
            }
            list.add(i);
            for (int o = 2; o < arr.length; o++) {
                try {
                    arr[i * o] = true;
                } catch (Exception e) {
                    break;
                }
            }
        }

        HashMap<BigInteger, Integer> hash = new HashMap<>();
        while (true) {
            BigInteger a = s.nextBigInteger();
            int b = s.nextInt();
            if (b == 0 && a.compareTo(BigInteger.ZERO) == 0) {
                break;
            }

            int p = Integer.MAX_VALUE;
            for (Integer k : list) {
                if (hash.containsKey(a)) {
                    p = hash.get(a);
                    break;
                }
                if (a.mod(BigInteger.valueOf(k.intValue())).compareTo(BigInteger.ZERO) == 0) {
                    hash.put(a, k);
                }
            }
            hash.put(a, p);
            p = hash.get(a);
            System.out.println(b > p ? "BAD " + p : "GOOD");
        }

    }
}
