import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class challenge {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner s = new Scanner(System.in);
        BigInteger m = s.nextBigInteger();
        int comp = m.compareTo(BigInteger.ZERO);
        if (comp == 0) {
            System.out.println(1);
            return;
        }
        BigInteger n = m.abs();
        BigInteger val = n.multiply(n.add(BigInteger.ONE)).divide(BigInteger.TWO)
                .subtract(comp <= 0 ? BigInteger.ONE : BigInteger.ZERO);
        System.out.println(val.multiply(BigInteger.valueOf(comp)).toString());

    }
}
