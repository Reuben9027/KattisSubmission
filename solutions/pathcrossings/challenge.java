import java.util.*;



class Query{
	int p;
	int time =0;

	int x= 0;
	int y =0;
    public Query(int p ,int x, int y , int time) {
		this.p = p;
		this.x =x;
		this.y = y;
		this.time=  time;
    }	
}

class Comp implements Comparator<Query>{
	public int compare(Query a, Query b){
		return Integer.compare(a.time, b.time);
	}
}

class Group{
	int a = 0;
	int b = 0;
	Group(int a, int b){
		this.a =a;
		this.b =b;
	}
}

class Comp2 implements Comparator<Group>{
	public int compare(Group a, Group b){
		 int j =Integer.compare(a.a, b.a);
		 if (j == 0) {
			 return Integer.compare(a.b, b.b);
		 }
		 return j;
	}
}
public class challenge{
	static boolean check(Query a, Query b){
		if (a.p == b.p) {
			return false;
		}
		double r = Math.hypot(a.x - b.x, a.y - b.y);
		return r<=1000;
	}
    public static void main (String[] args) throws java.lang.Exception{
		Scanner s = new Scanner(System.in);
		int n =s.nextInt();
		int m = s.nextInt();

		ArrayList<Query> list =new ArrayList<>();
		for(int i =0; i <m ; i++){
			int p  =s.nextInt() -1;
			int x  =s.nextInt();
			int y  =s.nextInt();
			int t  =s.nextInt();
			list.add(new Query(p,x,y , t));
		}
		list.sort(new Comp());

		ArrayList<Group> list2 = new ArrayList<>();
		boolean hash[][] = new boolean[n][n] ;

		for(int i= 0; i< m; i++){
			Query k = list.get(i);			

			int o = i;
			while(o++< list.size()){
				try {	
					Query j = list.get(o);
					int time = Math.abs(j.time - k.time);
					int min = Math.min(j.p, k.p);
					int max = Math.max(j.p, k.p);		
					if (time > 10) {
						break;
					}
					if ( hash[min][max] ) {
						continue;
					}
					if (check( k, j)) {
						list2.add( new Group(min+1, max+1));
						hash[min][max] = true;
					}	
				} catch (Exception e) {
					break;
				}
			}
		}
		list2.sort(new Comp2());
		System.out.println(list2.size());
		String result = "";
		for(Group g : list2){
			result+=  g.a +" " + g.b+"\n";
		}
		System.out.println(result);
   	}	
}