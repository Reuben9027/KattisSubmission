import java.io.*;
import java.util.*;
import java.math.*;

public class challenge {

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        long n = s.nextLong();
        long j = (n / 3) - (n % 3 == 0 ? 1 : 0);
        long k = (n / 5) - (n % 5 == 0 ? 1 : 0);
        long l = (n / 15) - (n % 15 == 0 ? 1 : 0);

        BigInteger jB = BigInteger.valueOf(j);
        BigInteger kB = BigInteger.valueOf(k);
        BigInteger lB = BigInteger.valueOf(l);
        jB = jB.multiply(jB.add(BigInteger.ONE)).divide(BigInteger.TWO).multiply(BigInteger.valueOf(3L));
        kB = kB.multiply(kB.add(BigInteger.ONE)).divide(BigInteger.TWO).multiply(BigInteger.valueOf(5L));
        lB = lB.multiply(lB.add(BigInteger.ONE)).divide(BigInteger.TWO).multiply(BigInteger.valueOf(15L));
        System.out.println(jB.add(kB).subtract(lB).toString());

    }
}