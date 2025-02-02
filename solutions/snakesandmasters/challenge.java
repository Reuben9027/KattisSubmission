import java.io.*;
import java.util.HashMap;
import java.util.Scanner;


public class challenge{

    static HashMap<Integer, Integer> hash = new HashMap<>();

    static int solve(int n){
        if (hash.containsKey(n)) {
            return hash.get(n);
        }
        if (n ==0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        int r=0;
        r += solve(n-2)%1000000;
        r += solve(n-1)%1000000;
        r%= 1000000;
        hash.put(n,r);
        return r;
    }

    public static void main(String[] args) throws IOException{
        Scanner  s= new Scanner(System.in);
        solve(10000);
        System.out.println(hash.get(s.nextInt()));

    }
}
