import java.lang.*;
import java.util.*;


class PrimeNumber{
    int num = 0;
    int arr[] = new int[10];
    PrimeNumber(int n){
        this.num = n;
        while(n>0){
            arr[n%10]++;
            n/=10;
        }
    }

    boolean check(int[] arrTemp){
        for(int i = 0; i< 10; i++){
            if (arrTemp[i]<arr[i]) {
                return false;
            }
        }
        return true;
    }
}

public class challenge{
    static boolean[] hash = new boolean[10000000];
    static ArrayList<PrimeNumber> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);


        int in = 1;
        for(int i = 2; i<= 9999991; i+=in){
            if (i==3) {
                in =2;
            }
            if(hash[i]){
                continue;
            }
            list.add(new PrimeNumber(i));
            int p = 2;
            while(p*i <= 9999991){
                hash[p*i] = true;
                p++;
            }
        }

        //System.out.println(list.getLast().num);

        int t= s.nextInt();
        while(t-->0){
            String k = s.next();
            int arr[] = new int[10];

            for(int i = 0; i< k.length(); i++){
                arr[k.charAt(i) - '0'] ++;
            }
            int r= 0 ;
            for(PrimeNumber p : list){
                r+= p.check(arr)? 1:0;
            }
            System.out.println(r);
        }
    }
}
 