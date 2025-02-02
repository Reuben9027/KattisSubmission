import java.io.*;
import java.util.*;
 
 
 
class Wall{
    long start;
    long end;

    Wall(long s, long e){
        this.start =s;
        this.end =e;
    }
}

class Comp implements Comparator<Wall>{
    @Override 
    public int compare(Wall a, Wall b){
        int r = Long.compare(a.start, b.start);
        if (r == 0) {
            return Long.compare(a.end, b.end); 
        }
        return r;
    }
}

public class challenge{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer strTok = new StringTokenizer(br.readLine()," "); 
        long n =Long.parseLong(strTok.nextToken());
        long k =Long.parseLong(strTok.nextToken());

        ArrayList<Wall> list = new ArrayList<>();
        for(long i = 0; i < k; i++){
            strTok = new StringTokenizer(br.readLine()," "); 
            long temp1 = Long.parseLong(strTok.nextToken());
            long temp2 = Long.parseLong(strTok.nextToken());

            if (temp1> n) {
                continue;
            }
            temp2 = Math.min(temp2, n);
            Wall tempWall = new Wall(temp1,temp2);
            list.add(tempWall);
        }
        list.sort(new Comp());


        long result = 0;
        Wall first = list.get(0);
        Wall current= new Wall(first.start, first.end); 
        int size = list.size();
        for(int i = 1; i< size; i++){
            Wall temp = list.get(i);
            if (current.start<= temp.start && temp.start<=current.end ) {
                current.end = Math.max( temp.end, current.end);
                continue;
            }
            if (current.start<= temp.end && temp.end<=current.end ) {
                current.start = Math.min( temp.start, current.start);
                continue;
            }
            result+= current.end - (current.start-1);
            current.start = temp.start;
            current.end = temp.end;
        }
        result+= current.end - (current.start-1);
        System.out.println(result);
        System.out.println( n/2<result?  "The Mexicans took our jobs! Sad!":"The Mexicans are Lazy! Sad!" );

    }
}
