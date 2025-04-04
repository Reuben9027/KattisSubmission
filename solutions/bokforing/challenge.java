import java.util.*;

class People{
	int m = 0;
	int r = 0;
}
public class challenge{
    public static void main (String[] args) throws java.lang.Exception{
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int q = s.nextInt();
		People[] arr = new People[n];
		for(int i = 0; i< n; i++){
			arr[i] = new People();
		}

		int p = 0; 
		int mT = 0; //money
		for(int i = 0; i< q; i++){
			String j = s.next();
			if (j.equals("SET")) {
				int k = s.nextInt() -1;
				int m = s.nextInt();
				arr[k].m = m;
				arr[k].r = p;
			}else if (j.equals("RESTART")) {
				mT = s.nextInt();
				p++;
			}else{
				int k = s.nextInt() -1;
				System.out.println( arr[k].r == p? arr[k].m: mT);
			}
		}

   	}	
}