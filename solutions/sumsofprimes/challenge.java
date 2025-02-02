import java.io.*;
import java.util.*;
class challenge{
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        long arrRes[] = new long[10000001];
        boolean arr[] = new boolean[10000001];

        long r = 0;
        for(int i = 2; i< arr.length; i++){
            arrRes[i] = r;
            if(!arr[i]){ 
                for(int o = i*2; o<arr.length;o+=i ){
                    arr[o] = true;
                }
                r+=i;
            }
        }

        System.out.println(arrRes[s.nextInt()]);

        

    }
}
