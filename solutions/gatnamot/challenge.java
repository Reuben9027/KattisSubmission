import java.lang.*;
import java.util.*;

public class challenge{
	public static void main (String[] args) throws java.lang.Exception
	{
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long r = 0;

        int x = n;
        int y = 0;

        //int depth = 0;
        while(y!=n){
            double p = Math.hypot(x, y);
            while(p>n){
                p = Math.hypot(--x, y);
                //depth++;
            }
            r+= x;
            y++;
        }
        System.out.println(((4*r)) +1);

	}
}
 