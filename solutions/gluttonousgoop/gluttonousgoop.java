import java.util.*;
public class gluttonousgoop{

    static void check(boolean arr[][], int i , int o){
        try {
            arr[i][o] = true;
        } catch (Exception e) {
        }
    }
    static boolean[][] solve(boolean arr[][]){
        int n= arr.length;
        int m = arr[0].length;
        boolean k[][] = new boolean[n][m];
        for(int i = 0; i < n ; i++){
            for(int o = 0; o < m ; o++){
                if (arr[i][o]) {
                    k[i][o] = true;
                    check(k, i-1, o-1);
                    check(k, i-1, o);
                    check(k, i-1, o+1);

                    check(k, i, o-1);
                    check(k, i, o+1);

                    check(k, i+1, o-1);
                    check(k, i+1, o);
                    check(k, i+1, o+1);
                }
            }
        }
        return k;
    }
    public static void main (String[] args) throws java.lang.Exception{
        Scanner s = new Scanner(System.in); 
        int n =s.nextInt();
        int m =s.nextInt();
        int k =s.nextInt();

        boolean arr [][]= new boolean[100][100] ;
        int offset = 20>=k ? k/2 : 0;
        for(int i = 0; i< n; i++){
            String temp  = s.next();
            for(int o = 0 ;o < m ;o++){
                if (temp.charAt(o) == '#') {
                    arr[(50-(offset + i)) ][(50-(offset + o))] = true;    
                }
                
            }
        }

        int j = Math.min(k, 20);
        for(int i = 0; i< j; i++){
            arr = solve(arr);
        }

        
        int lX= Integer.MAX_VALUE;
        int lY = Integer.MAX_VALUE;

        int uX = Integer.MIN_VALUE;
        int uY =  Integer.MIN_VALUE;


        long res = 0;
        for(int i = 0; i< arr.length; i++){
            for(int o = 0 ;o < arr[0].length ;o++){
                if (arr[i][o]) {
                    res += 1; 
                    lX = Math.min(o, lX);
                    lY = Math.min(i, lY);
                    uX = Math.max(o, uX);
                    uY = Math.max(i, uY);
                }
            }
        }
        if (k <= 20 || res ==0) {
            System.out.println(res);
            return;    
        } 

        res = 0;
        for(int i = lY; i<=uY; i++ ){
            for(int o = lX ; o<=uX; o++){
                res += !arr[i][o]? 1:0;
            }
        }


        long x = Math.abs(lX -uX) + ((k- 20)*2)+1;
        long y = Math.abs(lY -uY) + ((k- 20)*2)+1;
        System.out.println((x*y) - res);
        



    }   
}