import java.util.*;


public class different{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in );
        while(s.hasNextLine()){
            System.out.println( Math.abs(s.nextLong() - s.nextLong()));
            s.nextLine();
        }
        
    }
}