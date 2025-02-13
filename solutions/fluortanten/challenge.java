import java.io.*;
import java.lang.*;
import java.util.*;
public class challenge{
	public static void main (String[] args) throws java.lang.Exception
	{
        Scanner s = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n=Integer.parseInt(br.readLine());

        StringTokenizer strTok = new StringTokenizer(br.readLine(), " ");
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i< n; i++){
            int temp= Integer.parseInt(strTok.nextToken());
            if(temp == 0){
                continue;
            }
            list.add(temp);
            //System.out.println();
        }
        
        long pre = 0;
        for(int i = 0; i< list.size(); i++){
            pre += list.get(i)*(i+2);
        }

        long max= pre;
        for(int i = 0; i< list.size(); i++){
            long temp = list.get(i)*(i+2);
            pre -= temp;
            pre += list.get(i)*(i+1);
            max= Math.max(max,pre);
        }

        System.out.println(max);

	}
}
 