import java.lang.*;
import java.util.*;


class Word{
	int a;
	int b;

	int z ;

	void set(int p){
		this.z = p;
	}

	void swap(){
		set(alt());
	}

	int alt(){
		return (this.a+this.b) - this.z;
	}
	
	Word( int a, int b){
		this.a = a;
		this.b = b;
	}
}

class challenge{
	static Word [] hash;
	static boolean [] hash2;

	static boolean solve(int k){
		if (hash2[k]) {
			return false;
		}

		boolean p = true;
		Word z = hash[k];
		int next = z.alt();
		hash2[k] = true;
		if ( hash[next] != null ) {
			p &= solve(next);
		}
		if (p) {
			Word temp = z;
			hash[k] = null;
			hash[next] = temp;	
			temp.swap();
		}
		hash2[k] = false;
		return p;
	}

    public static void main (String[] args) throws java.lang.Exception{
		Scanner s = new Scanner(System.in);
		int t= s.nextInt();
		while(t -->0){
			int m = s.nextInt();
			int n = s.nextInt();
			boolean rehash = false;
			hash = new Word[n+1];
			hash2 = new boolean[n+1];
			for (int i = 0; i< m; i++) {
				int a  =s.nextInt();
				int b  =s.nextInt();
				Word k = new Word(a, b);
				if (rehash) {
					continue;
				}
				if (hash[a] == null) {
					hash[a] = k;
					k.set(a);
				}else if (hash[b] == null){
					hash[b] = k;
					k.set(b);
				}else{
					if (solve(a) && hash[a] == null) {
						hash[a] = k;
						k.set(a);
					}else if(solve(b) && hash[b] == null){
						hash[b] = k;
						k.set(b);
					}else{
						rehash = true;
					}
				}


			}
			System.out.println(rehash? "rehash necessary":"successful hashing");

		}
    }

}