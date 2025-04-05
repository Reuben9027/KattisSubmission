import java.math.BigInteger;
import java.util.*;
public class challenge{
    static BigInteger[] hash = new BigInteger[10003];
    static BigInteger[] hash2=  new BigInteger[10003];

    static BigInteger solve2(int n){
        if (hash2[n] == null) {
            hash2[n] = solve(2*n, n).divide(BigInteger.valueOf(n+1));
        }
        return hash2[n];
    }
    static BigInteger solve(int n, int k){
        BigInteger kB = hash[k];
        BigInteger nB = hash[n];
        BigInteger nkB = hash[n - k];
        return nB.divide(nkB).divide(kB);
    }
    public static void main (String[] args) throws java.lang.Exception{
        Scanner s = new Scanner(System.in);

        BigInteger temp  = BigInteger.ONE;
        hash[0] =temp;

        int n =s.nextInt()+1;
        for(int i =1;i<=2*n;i++ ){
            temp = temp.multiply(BigInteger.valueOf(i));
            hash[i] = temp;
        }
        System.out.println(solve2(n).toString());


    }   
}