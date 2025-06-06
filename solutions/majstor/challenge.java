import java.lang.*;
import java.util.*;

public class challenge{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner s= new Scanner(System.in);
        char[] hash =new char[256];
        hash[(int) 'S'] = 'P';
        hash[(int) 'P'] = 'R';
        hash[(int) 'R'] = 'S';
        
        int n =s.nextInt();
        String k =s.next();
        
        int m =s.nextInt();
        String[] arr = new String[m];
        for(int i =0 ;i<m ; i++){
            String k2 = s.next();
            arr[i] = k2;
        }
        
        int max= 0;
        int real=0;
        for(int i = 0; i< n; i++){
            
            int hash2[] = new int[256];
            for(int o = 0; o< m; o++){
                char c = arr[o].charAt(i);
                hash2[(int)c]++;
                
                // if(c == k.charAt(i)){
                //     real++;
                // }else if(hash[k.charAt(i)] == c){
                //     real+= 2;
                // }
            }
			real+= hash2[hash[k.charAt(i)]]*2 +hash2[k.charAt(i)];
            int scoreS = hash2['P']*2 + hash2['S'];
            int scoreR = hash2['S']*2 + hash2['R'];
            int scoreP = hash2['R']*2 + hash2['P'];
            max +=Math.max(scoreS,Math.max(scoreR, scoreP));
        }
        System.out.println(real);
        System.out.println(max);
	}
}
