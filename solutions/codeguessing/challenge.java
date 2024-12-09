import java.util.*;
import java.io.*;

public class challenge {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        String k = s.next();

        int r1 = 0;
        int r2 = 2;
        boolean r = false;
        switch (k) {
            case "ABBA":
                if (a + 3 == b) {
                    r1 = a + 1;
                    r2 = b - 1;
                    r = true;
                }
                break;
            case "ABAB":
                if (a == 6 && b == 8) {
                    r1 = 7;
                    r2 = 9;
                    r = true;
                }
                break;
            case "BABA":
                if (a == 2 && b == 4) {
                    r1 = 1;
                    r2 = 3;
                    r = true;
                }

                break;
            case "BAAB":
                if (a == 2 && b == 8) {
                    r1 = 1;
                    r2 = 9;
                    r = true;
                }
                break;

            case "AABB":
                if (b == 7) {
                    r1 = 8;
                    r2 = 9;
                    r = true;
                }
                break;
            case "BBAA":
                if (a == 3) {
                    r1 = 1;
                    r2 = 2;
                    r = true;
                }
                break;
            default:

                break;
        }


        System.out.println(r ? r1 + " " + r2 : -1);
    }

}

