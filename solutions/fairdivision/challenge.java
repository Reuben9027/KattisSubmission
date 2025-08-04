import java.io.*;
import java.util.*;



class Person{
    int index= 0 ;
    long money =0;
    long cost =0;

    Person(long m){
        this.money = m;
    }

}

class Comp implements Comparator<Person>{
    @Override
    public int compare(Person a, Person b){
        int r =  Long.compare(a.money, b.money);

        if (r == 0) {
            return Integer.compare(b.index, a.index);
        }
        return r;

    }
}

public class challenge {
    public static void main(String[] args) throws IOException{
        Scanner s = new Scanner(System.in);
        int t=s.nextInt();

        while(t-->0){
            long p =s.nextLong();
            int n =s.nextInt();

            ArrayList<Person> list = new ArrayList<>();
            Person arr[]= new Person[n];
            for(int i = 0 ;i< n;i++){
                long money = s.nextLong();
                Person temp = new Person(money);
                temp.index = i;

                arr[i] = temp;
                list.add(temp);
            }

            list.sort(new Comp());

            
            double tempN = n;
            double tempP = p;
            for(int i =0 ; i< n; i++){
                long ave = (long)Math.floor(tempP/tempN);
                long min= Math.min(list.get(i).money, ave);
                tempP-=min;
                tempN--;
                list.get(i).cost =min; 
            }

            if (tempP!=0) {
                System.out.println("IMPOSSIBLE"  );    
                continue;
            }

            for(Person k : arr){
                System.out.print(k.cost+" ");
            }
            System.out.println();
            

        }
        
    }
}