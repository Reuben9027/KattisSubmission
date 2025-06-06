import java.lang.*;
import java.math.*;
import java.util.*;

public class challenge{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner s= new Scanner(System.in);
        
        BigInteger a= s.nextBigInteger();
        BigInteger b= s.nextBigInteger();

    
        BigInteger c= s.nextBigInteger();
        BigInteger d= s.nextBigInteger();

        BigInteger gcd = c.gcd(d);
        BigInteger lcm = c.multiply(d).divide(gcd);
        //System.out.println(gcd.toString() +" " + lcm.toString());

        BigInteger left = a.subtract(BigInteger.ONE).divide(lcm);
        BigInteger right = b.divide(lcm);

        //System.out.println(left.toString() +" " + right.toString());
        System.out.println(right.subtract(left).toString());

	}
}
