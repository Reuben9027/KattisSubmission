
import java.io.*;
import java.util.*;

public class challenge {

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();


        long arr[] = new long[n];

        long min = Integer.MAX_VALUE;
        long max = 0;
        int minFirst = -1;
        int maxLast = -1; 
        for(int i = 0; i< n; i++){
            long temp =s.nextLong();
            arr[i] =temp;
            if (temp>min && minFirst == -1 &&min<=100) {
                minFirst = i-1;
            } 
            min = temp;
        }

        for(int i = n-1; i> minFirst; i--){
            long temp = arr[i];
            if (temp<max) {
                maxLast = i+1;
                break;
            }
            max = temp;
        }

        long money = 100;
        long shares = 0;
        long prevK = Integer.MAX_VALUE;
        boolean toSell = false;

        for(int i = minFirst ; i<= maxLast ; i++){
            try {
                long temp  = arr[i];
                if (toSell) {
                    if (temp < prevK) {
                        money += (shares * prevK);
                        shares = 0L;
                        toSell =false;
                    }
                } else { //toBuy
                    if (temp>prevK) {
                        long tempShare = shares<100000?Math.min(100000, (money / prevK)) : 0;
                        money -= prevK * tempShare;
                        shares += tempShare;
                        toSell = true;
                    }
                }
                prevK = temp;   
            } catch (Exception e) {
                break;
            }
        }

   
        
        System.out.println(money + (shares * prevK));
    }
}
