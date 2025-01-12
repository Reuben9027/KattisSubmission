import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

public class challenge {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();

        HashMap<Integer, Integer> hash = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int c = 1;
        for (int i = 0; i < k; i++) {
            char temp = s.next().charAt(0);
            if (hash.containsKey(i)) {
                queue.add(hash.get(i));
            }
            if (temp == 'a') {
                if (queue.isEmpty()) {
                    System.out.println(c++);
                    continue;
                }
                System.out.println(queue.poll());
            } else {
                hash.put(i + n, s.nextInt());
            }
        }
    }
}
