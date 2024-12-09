import java.util.*;
import java.io.*;

public class challenge {
    public static void main(String[] args0) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int q = 0; q < t; q++) {
            br.readLine();
            String[] nk = br.readLine().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            ArrayList<Double> list = new ArrayList<>();
            double sumCs = 0;
            StringTokenizer strTok = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                double temp = Double.parseDouble(strTok.nextToken());
                list.add(temp);
                sumCs += temp;
            }
            // list.sort(null);
            sumCs /= (double) n;

            strTok = new StringTokenizer(br.readLine(), " ");
            double sum = 0;
            for (int i = 0; i < k; i++) {
                sum += Double.parseDouble(strTok.nextToken());
            }
            sum /= (double) k;

            int r = 0;
            long c = 0;
            for (double p : list) {
                r += sum < p && sumCs > p ? 1 : 0;
            }

            bw.append("" + r);
            bw.newLine();

        }
        bw.flush();
    }
}
