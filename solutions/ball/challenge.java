import java.io.*;
import java.util.*;
class challenge{
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer,String> hash = new HashMap<>();
        int m= Integer.parseInt(br.readLine());
        int n =(m/2)+1;
        String r = "";
        String k ="";
        for(int i = 0; i< n; i++){
            String q[] = br.readLine().split(" ");
            int a =Integer.parseInt(q[0]);
            int b= Integer.parseInt(q[1]);
            String j = Math.min(a,b) + " " + Math.max(a,b);
            if(hash.containsKey(a) || hash.containsKey(b) || a == b){
                r= j;
                k = hash.containsKey(a)? hash.get(a): hash.get(b);
                continue;
            }
            hash.put(a,j);
            hash.put(b,j);
        }
        boolean p = true;
        for(int i = 1; i<=m && p; i++){
            p &= hash.containsKey(i);
        }
        System.out.println(p? r: k);

    }
}
