import java.lang.*;
import java.util.*;
class ornaments{

    public static void main (String[] args) throws java.lang.Exception{
		Scanner s = new Scanner(System.in);
		while(true){
			double r= s.nextDouble();
			double h= s.nextDouble();
			double k= s.nextDouble();
			if (r ==0 && h == 0 && k == 0) {
				break;
			}
			double tanLen =  Math.sqrt((h*h)- (r*r));
			double angle = 180 -Math.toDegrees(Math.acos(r/h));
			double arc = (angle/360)*2*Math.PI*r;
			double result = ((tanLen*2)+(arc*2)) * ( 1+(k/100));
			System.out.printf("%.2f\n",result);
		}

   	}

}