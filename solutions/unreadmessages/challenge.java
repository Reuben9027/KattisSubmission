import java.util.*;
public class challenge{
    public static void main (String[] args) throws java.lang.Exception{
		Scanner s = new Scanner(System.in);

		int n=s.nextInt();
		int m =s.nextInt();
		HashMap<Integer, Integer>hash = new HashMap<>();
		long r=  0;
		for(int i = 0; i< m; i++){
			int temp =s.nextInt();
			if (!hash.containsKey(temp)) {
				hash.put(temp, 0);
			}
			r += n-1;
			r -=i- hash.get(temp);
			hash.put(temp , i+1);
			System.out.println(r);
		}

   	}	
}