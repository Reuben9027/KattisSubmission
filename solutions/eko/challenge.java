import java.io.*;
import java.lang.*;
import java.util.*;


class Num{
	long n = 0;
	long quan = 0;
	int index= 0;
	Num(long k){
		this.n = k;
	}

	long getTotal(){
		//return n.multiply(BigInteger.valueOf(quan));
		return n*quan;
	}
}

class Comp implements Comparator<Num>{
	@Override
	public int compare(Num a , Num b){
		return Long.compare(a.n, b.n);
	}
}

class challenge{
    public static void main (String[] args) throws java.lang.Exception{
		//Scanner s = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] q = br.readLine().split(" ");
		int n = Integer.parseInt(q[0]);
		long m = Long.parseLong(q[1]);

		HashMap<Long, Num> hash = new HashMap<>();
		ArrayList<Num> list = new ArrayList<>();
		list.add(new Num(0));

		StringTokenizer strTok = new StringTokenizer(br.readLine());
		for(int i = 0;  i< n; i++){
			long p =  Long.parseLong(strTok.nextToken());
			if (!hash.containsKey(p)) {
				Num a = new Num(p);
				hash.put(p, a);
				list.add(a);
			}
			hash.get(p).quan++;
		}
		list.sort(new Comp());



		long total = 0;
		long prev = 0;
		int nTemp = n;
		int index= 0;
		for(Num k: list){
			total += k.getTotal();
			k.index=index++;
		}

		Num last = null;
		for(int i = 0; i < list.size() ; i++){
			Num k = list.get(i);
			long temp = total;
		

			total = total - ( (k.n - prev) * nTemp );
			if (total< m) {
				total = temp;
				last = k;
				break;
			}
			nTemp-=k.quan;
			prev = k.n;
			last = k;
			//total = total.subtract(k.getTotal());
		}

		
		// if ( m.compareTo(total) == 0) {
		// 	System.out.println(last.n.toString());
		// 	return;
		// }
		long l= list.get(last.index-1).n;
		prev = l;
		//nTemp += last.quan;
		long r= last.n;

		while(l<r){
			//BigInteger mid = r.add(l).divide(BigInteger.TWO);
			long mid= (r+l)/2;
			//BigInteger temp = total.subtract((mid.subtract(prev)).multiply(BigInteger.valueOf(nTemp)));\
			long temp = total - ( (mid - prev) * nTemp );
			int c1 = Long.compare( temp , m);
			
			if(c1 > 0){
				if (l == mid) {
					r= mid;					
				}
				l = mid;
			}else if (c1 < 0) {
				if (r == mid) {
					l = mid;					
				}
				r = mid;
			}else{
				l = mid;
				break;
			}
		}


		System.out.println(l);

    }
}