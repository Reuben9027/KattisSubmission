
import java.io.*;
import java.util.*;
class challenge{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t= Integer.parseInt(br.readLine());
        while(t-->0){
            StringTokenizer strTok = new StringTokenizer(br.readLine(), " /");
            int n = Integer.parseInt(strTok.nextToken());
            int p = Integer.parseInt(strTok.nextToken());
            int q = Integer.parseInt(strTok.nextToken());

            Stack<Boolean> stack = new Stack<>();
            while(p!=1 || q!= 1){
                if(p>q){//from right
                    p = p-q;
                    stack.add(true);
                }else{//from left 
                    q = q-p;
                    stack.add(false);
                }
            }
            long r= 1;
            while(!stack.empty()){
                r *=2;
                r += stack.pop()?1:0;
            }
            System.out.println(n + " " + r);

        }
    }
}
