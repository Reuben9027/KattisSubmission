import java.lang.*;
import java.util.*;


public class challenge{

    static boolean check(int h, long hash[], int arr[]){
        long hash2[] = hash.clone();
        for(int i = 0; i< h; i++){
            int temp = arr[i] -1;

            hash2[temp] -= Math.pow(h-i, 2);
            if (hash2[temp] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner s= new Scanner(System.in);
        int n =s.nextInt();
        int m =s.nextInt();

        long arr[] = new long[n];
        long total = 0;
        int arr2[] = new int[m];

        for(int i= 0 ;i< n ; i++){
            long temp =s.nextLong();
            arr[i] =temp;
            total +=temp;
        }

        for(int i= 0 ;i< m ; i++){
            arr2[i] =s.nextInt();
        }

        int l = 0;
        int r = m+1;

        while(l<r){
            int mid = (l+r)/2;
            boolean check  =check( mid, arr,arr2);


            if (mid == l || mid == r) {
                l = mid;
                break;
            }
            if (check) {
                l = mid;
            }else{
                r = mid;
            }
        }

        System.out.println(l);

    }
}