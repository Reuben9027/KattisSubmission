import java.util.*;

public class challenge{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        
        do{
            String b = s.nextLine();
            String name = "";
            double average = 0;
            int n = 0;
            
            StringTokenizer strTok = new StringTokenizer(b);
            int p = strTok.countTokens();
            for(int i = 0; i< p; i++){
                String k = strTok.nextToken();
                try{
                    average+= Double.parseDouble(k);
                    n++;
                }catch(Exception e){
                    name = name + " " + k;
                }
                
                
            }
            
            System.out.printf("%f %s\n", average/(double)n, name );
            
        } while(s.hasNextLine());
        
        
    
    }
}