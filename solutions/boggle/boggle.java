import java.util.*;
import java.lang.*;
import java.io.*;


class Comp implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        int r= Integer.compare(o1.length(), o2.length());
        if(r ==0 ){
            r= o2.compareTo(o1);
            return r;
        }
        return r;
    }

}

public class boggle{
    static HashSet<String> hash = new HashSet<>();
    static HashSet<String> hash2 = null;
    static char arr[][] = null;
    static boolean back[][]  = null;
    static int longest = 0;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<String> list  = null;

    static void solve(int x, int y){
        try {
            if(back[y][x]){
                return;
            }   
            back[y][x] = true;
            sb.append(arr[y][x]);

            if(sb.length() > longest){
                sb.deleteCharAt(sb.length() -1);
                back[y][x] = false;
                return;
            }
            String k = sb.toString();
            if(hash.contains(k) && !hash2.contains(k)){
                hash2.add(k);
                list.add(k);
            }

            solve(x+1, y);
            solve(x-1, y);

            solve(x, y+1);
            solve(x, y-1);

            solve(x+1, y+1);
            solve(x-1, y+1);

            solve(x+1, y-1);
            solve(x-1, y-1);
            sb.deleteCharAt(sb.length() -1);
            back[y][x] = false;
        } catch (Exception e) {
        }
    }





	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Scanner s = new Scanner(System.in);
        Comp comp = new Comp();
        long scoring[] = new long[10];
        scoring[3] = 1;
        scoring[4] = 1;
        scoring[5] = 2;
        scoring[6] = 3;
        scoring[7] = 5;     
        scoring[8] = 11;     


        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i<n ; i++){
            String temp =br.readLine();
            longest = Math.max(temp.length(), longest);
            hash.add(temp);
        }
        br.readLine();
        int k = Integer.parseInt(br.readLine());

        for(int q = 0; q< k; q++){
            hash2 = new HashSet<>();
            back = new boolean[4][4];
            arr = new char[4][];
            list = new ArrayList<>();

            for(int o =0 ; o< 4; o++){
                arr[o] = br.readLine().toCharArray();
            }
            
            for(int i = 0; i< 4; i++){
                for(int o = 0; o< 4; o++){
                    solve(o, i);
                }
            }

            long score= 0;
            String r ="";
            long size = list.size();
            for(String p :list){
                if(comp.compare(p, r) >= 1){
                    r = p;
                }
                score += scoring[p.length()];
            }
            System.out.println( score+" "+ r +" " + size);

            if(q== k-1){
                break;
            }
            br.readLine();
        }



	}
}
 