import java.io.*;
import java.lang.*;
import java.util.*;

class Book{
    String book = null;
    String author = null; 
    Book(String b , String a){
        this.book= b;
        this.author = a;
    }
}

class Comp implements Comparator<Book>{

    @Override
    public int compare(Book a, Book b){
        int r = a.author.compareTo(b.author);
        if (r ==0) {
            return a.book.compareTo(b.book);
        }
        return r;
    }
}

public class challenge{
	public static void main (String[] args) throws java.lang.Exception
	{
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        String[] k = br.readLine().split(" ");
        int n= Integer.parseInt(k[0]);
        int m= Integer.parseInt(k[1]);
        ArrayList<Book>list = new ArrayList<>();
        HashMap<String, Integer> hash = new HashMap<>();
        for(int i = 0; i< n ;i++){
            StringTokenizer strTok = new StringTokenizer(br.readLine(), ", ");
            list.add(new Book(strTok.nextToken(),strTok.nextToken()));
        }
        list.sort(new Comp());

        for(int i = 0; i< n; i++){
            hash.put(list.get(i).book, i+1);
        }

        for(int i = 0; i< m; i++){
            String p = br.readLine();
            if (hash.containsKey(p)) {
                System.out.println(hash.get(p));
            }else{
                System.out.println(-1);
            }
        }


	}
}
 