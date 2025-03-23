import java.lang.*;
import java.util.*;

class Robot{
	static int hash[][] = new int[256][2];
	static int hash2[] = new int[256];
	static String rotation = "NESW";
	static void init(){
		hash2['N'] = 0;
		hash2['E'] = 1;
		hash2['S'] = 2;
		hash2['W'] = 3;
		//0==x
		hash['N'][0]=0;
		hash['N'][1]=1;

		hash['S'][0]=0;
		hash['S'][1]=-1;

		hash['W'][0]=-1;
		hash['W'][1]=0;

		hash['E'][0]=1;
		hash['E'][1]=0;
	}

	int[] delta=  new int[2];

	int x= 0;
	int y = 0;
	int n= 0;

	int r =0;

	int[] getDelta(){
		return  hash[rotation.charAt(r)];
	}

	Robot(int x, int y, char c){
		this.x= x;
		this.y= y;
		this.r = hash2[c];
	}
}

public class challenge{

	static String solve(Robot[][] grid, Robot r, int n){
		int xD= r.getDelta()[0];
		int yD= r.getDelta()[1];
		for(int i =0; i < n; i++){
			int fX= r.x+xD;
			int fY = r.y+yD;
			try {
				if (grid[fY][fX] == null) {
					grid[r.y][r.x] = null;
					grid[fY][fX] = r;
					r.x = fX;
					r.y = fY;
					continue;
				}
				return "Robot " +r.n+" crashes into robot "+ grid[fY][fX].n;
				
			} catch (Exception e) {
				return "Robot " +r.n + " crashes into the wall";
			}
		}
		return null;
	}
    public static void main (String[] args) throws java.lang.Exception{
		Scanner s = new Scanner(System.in);
		int t= s.nextInt();
		Robot.init();
		while(t-->0){
			int a =s.nextInt();
			int b = s.nextInt();

			int n =s.nextInt();
			int m =s.nextInt();

			Robot[][] grid= new Robot[b][a];
			Robot[] arr = new Robot[n+1];
			for(int i = 1; i<= n; i++){
				Robot temp = new Robot(s.nextInt()-1, s.nextInt()-1, s.next().charAt(0));
				temp.n= i;
				grid[temp.y][temp.x] = temp;
				arr[i]  =temp;
			}

			String result = null;

			for(int i = 0; i< m; i++){
				int robot = s.nextInt();
				char p = s.next().charAt(0);
				int rep = s.nextInt();
				if (result != null) {
					continue;
				}
				if (p == 'F') {
					String j =solve(grid, arr[robot], rep);	
					if (j != null) {
						result = j;
					}
				}else{
					arr[robot].r =(arr[robot].r+4+  ((p=='R'? 1: -1)*(rep%4 ))  ) %4;
				}
			}
			System.out.println(result == null?"OK":result);
		}
   	}	
}