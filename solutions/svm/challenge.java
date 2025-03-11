import java.lang.*;
import java.util.*;

class challenge{
    public static void main (String[] args) throws java.lang.Exception{
		Scanner s = new Scanner(System.in);
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=  s.nextInt();
		double arr[] = new double[t];

		double k = 0;
		for(int i = 0; i< t; i++){
			double temp  =s.nextDouble();
			arr[i] = temp;
			k+= temp*temp;
		}
		double  p = s.nextDouble();
		k = Math.sqrt(k);
		s.nextLine();

		while(s.hasNextLine()){
			StringTokenizer strTok = new StringTokenizer(s.nextLine());
			double sum = 0;
			for(int i = 0; i< t; i++){
				sum+= Double.parseDouble(strTok.nextToken()) *arr[i];
			}

			double result = (sum +p)/k;

			System.out.printf("%.5f\n",result);
		}

    }
}