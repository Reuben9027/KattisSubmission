import java.lang.*;
import java.math.*;
import java.util.*;

public class challenge{

    public static void solve(BigInteger a, BigInteger b,  BigInteger res){
        String r1=  a.toString()+"^2";
        String r2=  res.subtract(a.pow(2)).sqrt().toString() +"^2";

        String b1= b.toString()+"^2";
        String b2= res.subtract(b.pow(2)).sqrt().toString() +"^2";

        System.out.println(r1 + " + " + r2 + " = " + res.toString());
        System.out.println(b2 + " + " + b1 + " = " + res.toString());

    }
   
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner s= new Scanner(System.in);
        
        BigInteger  a= s.nextBigInteger();
        BigInteger  b= s.nextBigInteger();
        BigInteger  c= s.nextBigInteger();
        BigInteger  d= s.nextBigInteger();

        BigInteger ac = a.multiply(c);
        BigInteger ad = a.multiply(d);
        
        BigInteger bc = b.multiply(c);
        BigInteger bd = b.multiply(d);


        

        BigInteger acbd = ac.add(bd);
        BigInteger adbc = ad.add(bc);

        BigInteger res  =acbd.pow(2).add(adbc.pow(2)).subtract(ac.multiply(bd).multiply(BigInteger.valueOf(4l)));

        solve(acbd,adbc, res);
        //solve(adbc, res);
        


    }
}
