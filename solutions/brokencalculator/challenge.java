import java.io.*;
import java.util.StringTokenizer;
 
 
 
public class challenge{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n  = Integer.parseInt(br.readLine());


        long r = 1;
        for(int i = 0; i< n ; i++ ){
            StringTokenizer strTok = new StringTokenizer(br.readLine(), " ");
            long a = Long.parseLong(strTok.nextToken());
            char c = strTok.nextToken().charAt(0);
            long b = Long.parseLong(strTok.nextToken());
            switch (c) {
                case '*':
                    r = a*b;
                    r*=r;
                    break;
                case '+':
                    r = (a+b)-r;
                    break;
                case '-':
                    r = (a-b)*r;
                    break;
                case '/':
                    r= (a%2==1)? (a+1)/2: a/2;
                    break;

                default:
                    throw new AssertionError();
            }
            System.out.println(r);
        }
    }
}
