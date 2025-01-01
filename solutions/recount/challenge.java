import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class challenge {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> hash = new HashMap<>();
        int largest = 0;
        String name = "";
        boolean draw = true;

        while (true) {
            String k = br.readLine();
            if (k.equals("***")) {
                break;
            }

            if (!hash.containsKey(k)) {
                hash.put(k, 0);
            }
            hash.put(k, hash.get(k) + 1);

            int temp = hash.get(k);
            if (temp == largest) {
                draw = true;
                continue;
            }

            if (temp > largest) {
                name = k;
                largest = temp;
                draw = false;
            }
        }

        System.out.println(draw ? "Runoff!" : name);

    }
}