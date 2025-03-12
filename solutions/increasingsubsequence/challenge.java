import java.lang.*;
import java.util.*;

class challenge{
    public static void main (String[] args) throws java.lang.Exception{
		Scanner s = new Scanner(System.in);
		while(true){
			int n =s.nextInt();
			if (n == 0) {
				break;
			}

			long arr[] = new long[n];
			for(int i = 0; i< n; i++){
				long temp =s.nextLong();
				arr[i]  =temp;
			}

			long res[] = new long[n];
			int ref[] = new int[n];

			Arrays.fill(res, 1);
			Arrays.fill(ref, -1);
			long max = 1;
			for(int i = n-1; i>=0 ; i--){
				for(int o = i-1; o>=0; o--){
					if (arr[i] <= arr[o]) {
						continue;
					}
					long j =res[i]+1;
					if (j >= res[o]) {
						

						if (j == res[o]) {
							try {
								ref[o] = arr[ref[o]]> arr[i]?i:ref[o];
							} catch (Exception e) {
								ref[o] = i;
							}	
						}else{
							ref[o] = i;
						}
						
						res[o] = j;
						max = Math.max(max,res[o]);
					}
				}
			}


			int index = 0;
			for(int i = 0; i< n; i++){
				if (res[i] == max && arr[i] < arr[index] ) {
					index = i;
				}
			}
			
			String result = max + " ";
			int p = index;
			while(true){
				try {
					result+=arr[p] +" ";
					p = ref[p];
				} catch (Exception e) {
					break;
				}
			}
			System.out.println(result);
		}
    }

}