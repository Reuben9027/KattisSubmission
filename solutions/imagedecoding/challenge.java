import java.util.*;
import java.lang.*;
import java.io.*;


public class challenge{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        while(true){
            if(n ==0 ){
                break;
            }

            int max= -1;
            boolean error = false;
            for(int i = 0; i< n; i++){
                boolean k = false;
                StringTokenizer strTok = new StringTokenizer(br.readLine());
                k = strTok.nextToken().equals("#");
                String r = "";
                while(strTok.hasMoreTokens()){
                    r+= (k?"#":".").repeat(Integer.parseInt(strTok.nextToken()));
                    k=!k;
                }
                if(max == -1){
                    max = r.length();
                }
                if(max != r.length()){
                    error = true;
                }
                System.out.println(r);
            }
            if(error){
                System.out.println("Error decoding image");
            }
            n = Integer.parseInt(br.readLine());
            if(n!=0){
                System.out.println();
            }   
        }
	}
}
 