import java.lang.*;
import java.util.*;
public class challenge{
	static char [] hash = new char[256];

	static void solve(String k){
		for(int i = 1; i< k.length(); i++){
			hash[(int)k.charAt(i)]= k.charAt(i-1);
		}
	}
    public static void main (String[] args) throws java.lang.Exception{
		Scanner s = new Scanner(System.in);
		
		
		solve("QWERTYUIOP[]\\");
		solve("ASDFGHJKL;'");
		solve("ZXCVBNM,./");
		solve("`1234567890-=");
		//solve("~!@#$%^&*()_+");

		while(s.hasNextLine()){
			String p = s.nextLine();
			String j ="";	
			for(int i = 0; i< p.length(); i++){
				char cT =p.charAt(i);
				char c = hash[cT];
				if(c =='\0'){
					j+=cT;
				}else{
					j+=c;
				}
			}
			System.out.println(j);
		}
   	}	

}