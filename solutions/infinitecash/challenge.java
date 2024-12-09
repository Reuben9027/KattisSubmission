import java.util.*;

import javax.sound.sampled.Line;

import java.lang.*;
import java.math.BigInteger;
import java.io.*;

public class challenge {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        BigInteger salary = new BigInteger(s.next(), 2);
        BigInteger days = new BigInteger(s.next(), 2);
        BigInteger money = new BigInteger(s.next(), 2);

        HashSet<String> hash = new HashSet<>();
        BigInteger max = money;
        BigInteger result = BigInteger.ZERO;
        BigInteger realDay = BigInteger.ZERO;// days - 1;
        while (true) {
            money = money.divide(BigInteger.TWO);
            result = result.add(BigInteger.ONE);
            realDay = realDay.add(BigInteger.ONE).mod(days);
            if (realDay.equals(BigInteger.ZERO)) {
                money = money.add(salary);
                if (hash.contains(money.toString()) || money.compareTo(max) > -1) {
                    System.out.println("Infinite money!");
                    return;
                }
                hash.add(money.toString());
            }
            if (money.equals(BigInteger.ZERO)) {
                break;
            }
        }
        System.out.println(result.toString(2));
    }
}
