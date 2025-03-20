import java.lang.*;
import java.util.*;

class challenge{
    public static void main (String[] args) throws java.lang.Exception{
		Scanner s = new Scanner(System.in);
		int m  =s.nextInt();
		int n = s.nextInt();
		long k = s.nextLong();
		long[][]arr = new long[n][2];
		
		for(int i = 0; i< n; i++){
			long a = s.nextLong();
			long b = s.nextLong();
			arr[i][0] = a;
			arr[i][1] = b;
			// if(a ==0 && b %m ==0){
			// 	System.out.println("0");
			// 	continue;
			// }
			// if (a ==0) {
			// 	continue;
			// }
			// for(int o = 1; o<m+1; o++){
			// 	long c = (k*o);
			// 	if (c>m) {
			// 		break;
			// 	}
			// 	if((c-b)%a == 0){
			// 		hash[(int)((c-b)/a)] = true;
			// 	}
			// }
		}

		boolean[] hash2 = new boolean[m+1];
		ArrayList<Integer> list = new ArrayList<>();
		boolean[] hash3 = new boolean[m+1];
		list.add((int)k);

		int r = 1;
		outer:
		while(!list.isEmpty()){
			ArrayList<Integer> nList = new ArrayList<>();
			for(int j : list){
				for(int i = 0; i< n; i++){
					int p = (int)(((j* arr[i][0]) +arr[i][1]) %m);
					if (p == 0) {
						System.out.println(r);
						return;
					}
					if (hash3[p]) {
						continue;
					}
					hash3[p] = true;
					nList.add(p);
				}
			}
			list = nList;
			r++;
		}
		System.out.println("-1");
		
    }

}