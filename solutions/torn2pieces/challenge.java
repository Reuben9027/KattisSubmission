import java.util.*;

class Station{
	static HashSet<Station> hash = new HashSet<>();
	static Stack<String> stack = new Stack<>();
	String name = "";

	HashSet<Station> hash2 = new HashSet<>();
	ArrayList<Station> list = new ArrayList<>();

	void add(Station temp){
		if (hash2.contains(temp)) {
			return;
		}
		list.add(temp);
	}

	boolean solve(Station k){
		if (hash.contains(this)) {
			return false;
		}
		hash.add(this);
		for( Station temp :list){
			if (temp == k) {
				stack.add(k.name);
				stack.add(this.name);
				return true;
			}
		}
		for( Station temp :list){
			if (temp.solve(k)) {
				stack.add(this.name);
				return true;
			}
		}
		return false;
	}

	Station(String k ){
		this.name = k;
	}

}
public class challenge{
    public static void main (String[] args) throws java.lang.Exception{
		Scanner s = new Scanner(System.in);
		HashMap<String, Station> hash =new HashMap<>();
		int n = s.nextInt();
		s.nextLine();
		for(int i = 0; i< n; i++){
			StringTokenizer strTok = new StringTokenizer(s.nextLine());
			String p  =strTok.nextToken();
			if (!hash.containsKey(p)) {
				hash.put(p, new Station(p) );
			}

			Station temp = hash.get(p);

			while(strTok.hasMoreTokens()){
				p =strTok.nextToken();
				if (!hash.containsKey(p)) {
					hash.put(p, new Station(p) );
				}
				temp.add(hash.get(p));
				hash.get(p).add(temp);
			}

		}
		String start = s.next();
		String end = s.next();
		try {
			boolean solve = hash.get(start).solve(hash.get(end));
			if (solve) {
				String r = "";
				while(!Station.stack.isEmpty()){
					r+=Station.stack.pop()+" ";
				}
				System.out.println(r);
			}else{
				System.out.println("no route found");
			}
	
		} catch (Exception e) {
			System.out.println("no route found");
		}
   	}	
}