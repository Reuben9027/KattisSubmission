import java.util.*;

public class dfroggereasy{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int st= s.nextInt();
        int m= s.nextInt();
        
        
        int p[] = new int[n];
        for(int i = 0; i< n; i++){
            p[i] = s.nextInt();
        }
        
        int c = 0;
        boolean []hash = new boolean[n];
        do{
            try{
            if( p[st-1]  == m   ){
                System.out.println("magic");
                break;
            }
            
            if(hash[st-1]){
                System.out.println("cycle");
                break;
            }
            
            
            
            hash[st-1] = true;
            
            int temp = p[st-1];
            st+=temp;
            c++;
            }catch(Exception e){
                System.out.println(  st-1<0? "left":"right" );
                break;
            }
        }while (true);
        System.out.println( c );
     
        
    }
}

