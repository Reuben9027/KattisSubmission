import java.util.*;
import java.io.*;

public class challenge {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        qOuter: for (int q = 0; q < t; q++) {
            String str = br.readLine();

            iOuter: for (int i = 1; i <= str.length(); i++) {
                for (int o = 0; o < i; o++) {
                    char p = str.charAt(o);
                    for (int k = o; k < str.length(); k += i) {
                        if (p != str.charAt(k)) {
                            continue iOuter;
                        }
                    }
                }
                System.out.println(i);
                continue qOuter;
            }
        }
    }
}