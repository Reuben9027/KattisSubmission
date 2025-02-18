import java.io.*;
import java.lang.*;
import java.util.*;

public class challenge{
	public static void main (String[] args) throws java.lang.Exception
	{
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        String[] k = br.readLine().split(" ");
        int n = Integer.parseInt(k[0]);
        int m = Integer.parseInt(k[1]);

        long r =0;
        for(int i = 0; i< n; i++){
            StringTokenizer strTok = new StringTokenizer(br.readLine());
            ArrayList<Long>list = new ArrayList<>();
            for(int o = 0; o< 3; o++){
                long temp = Long.parseLong(strTok.nextToken());
                list.add(temp);
            }
            list.sort(null);
            if (list.get(1) <= m) {
                r+=list.get(0);
            }else if (list.get(0) <= m) {
                r+= list.get(1);   
            }else{
                System.out.println("impossible");
                return;
            }
        }
        System.out.println(r);
	}
}
 