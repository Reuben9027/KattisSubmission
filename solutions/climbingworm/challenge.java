import java.util.*;
import java.lang.*;
import java.io.*;

import java.math.*;

class challenge {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        int c = s.nextInt();
        c -= a;
        System.out.printf("%.0f\n", c <= 0 ? 1 : 1 + Math.ceil((double) c / (a - b)));
    }
}
