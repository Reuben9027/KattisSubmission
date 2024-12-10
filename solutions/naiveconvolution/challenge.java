import java.io.*;
import java.math.BigInteger;
//import java.io.InputStreamReader;
import java.util.*;

public class challenge {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();

        int max = n + m;
        BigInteger[] arr = new BigInteger[n + m + 2];
        BigInteger[] arr1 = new BigInteger[n];
        BigInteger sum = BigInteger.ZERO;

        for (int i = 0; i < n; i++) {
            arr1[i] = s.nextBigInteger();
        }
        for (int i = 0; i < m; i++) {
            BigInteger temp = s.nextBigInteger();
            for (int o = 0; o < n; o++) {
                BigInteger k = (arr1[o].multiply(temp));

                if (arr[i + o] == null) {
                    arr[i + o] = BigInteger.ZERO;
                }
                arr[i + o] = arr[i + o].add(k);
                sum = sum.add(k);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i].toString() + " ");
            sum = sum.subtract(arr[i]);
            if (sum.compareTo(BigInteger.ZERO) == 0) {
                break;
            }
        }
    }
}
