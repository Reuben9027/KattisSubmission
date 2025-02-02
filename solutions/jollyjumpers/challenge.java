import java.util.*;

public class challenge {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while (s.hasNextLine()) {
            int n = s.nextInt();

            long prev = 0;
            long prevDif = 0;
            boolean r = false;
            HashSet<Long> hash = new HashSet<>();
            for (int i = 0; i < n; i++) {
                int temp = s.nextInt();
                if (i == 0) {
                    prev = temp;
                    continue;
                }
                long dif = Math.abs(prev - temp);
                r |= !(1 <= dif && dif <= n - 1);
                if (!r) {
                    hash.add(dif);
                }
                prev = temp;
            }
            s.nextLine();
            System.out.println(!r && hash.size() == n - 1 ? "Jolly" : "Not Jolly");
        }
    }
}