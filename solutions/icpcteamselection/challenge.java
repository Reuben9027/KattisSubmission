import java.lang.*;
import java.util.*;

public class challenge{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner s= new Scanner(System.in);
        int t =s.nextInt();

        while(t-->0){
            int n =s.nextInt();     
            int[] arr = new int[3*n];
            for(int i = 0 ; i<arr.length; i++){
                arr[i] = s.nextInt();
            }
            Arrays.sort(arr);
            int r = 0;
            for (int i = 0 ; i<n; i++) {
                r+= arr[ arr.length - ((i+1) *2) ];
            }
            System.out.println(r);
        }
	}
}
