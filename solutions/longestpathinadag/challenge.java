import java.io.*;
import java.util.*;


class Vert{
    static ArrayList<Integer> result = new ArrayList<>();
    int index= -1;

    ArrayList<Vert> list = new ArrayList<>();
    int len = 0;
    Vert next = null;
    boolean isVisited= false;


    int check(){
        if (isVisited) {
            return len;
        }

        isVisited = true;
        for( Vert v :list){
            int lenV = v.check();
            if ( lenV+1 > len ) {
                len = lenV+1;
                this.next =v;
            }
        }

        return len ;
    }

    void print(){
        result.add(this.index);
        if (next == null) {
            return;
        }
        next.print();
    }
}

public class challenge {
    public static void main(String[] args) throws IOException{
        // Scanner s = new Scanner(System.in);
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer strTok = new StringTokenizer(br.readLine(), " ");
        // int n =s.nextInt();
        // int m =s.nextInt();
        int n =Integer.parseInt(strTok.nextToken());
        int m =Integer.parseInt(strTok.nextToken());
        
    

        Vert[] arr= new Vert[n];

        boolean[] hash = new boolean[n];
        boolean[] hash2 = new boolean[n];

        for(int i = 0; i< n; i++){
            arr[i] = new Vert();
            arr[i].index= i;
        }

        for(int i = 0;i<m; i++){
            strTok = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(strTok.nextToken()) -1;
            int b = Integer.parseInt(strTok.nextToken())-1;

            Vert aV = arr[a];
            Vert bV = arr[b];

            aV.list.add(bV);
            hash[a]= true;
            hash2[b] = true;
        }   
    

        ArrayList<Vert> last = new ArrayList<>();
        ArrayList<Vert> first = new ArrayList<>();
        // Vert last= null;
        // Vert first = null;
        for(int i = 0; i< n; i++){
            if(!hash[i]){
                last.add(arr[i]);
                // last = arr[i];
            }
            if (!hash2[i]) {
                first.add(arr[i]);
                // first = arr[i];
            }
        }


        for(Vert v :last){
            v.len = 1; v.isVisited = true;
        }

        for(Vert v :first){
            v.check();
        }

        Vert max = first.getFirst();
        for(Vert v: first){
            if(max.len< v.len){
                max = v;
            }
        }
        
        // first.check();

        max.print();

        System.out.println(Vert.result.size());

        StringBuilder result = new StringBuilder();

        for ( int k :Vert.result) {
            result.append(k+1).append(" ");
        }
        System.out.println(result);


    }
}