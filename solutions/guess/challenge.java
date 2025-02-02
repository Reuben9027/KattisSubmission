import java.util.*;

public class challenge{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int low = 1;
        int high = 1001;
        for(int i = 0; i< 10; i++){
            int t = (high+low)/2;
            System.out.println(t);
            String k = s.nextLine();
            if(k.equals("higher")){
                
                
                low = t;
                high = high;
            }else if( k.equals("lower")){
                low = low;
                high = t;
            }else{
                break;
            }
        }
        
    }
}