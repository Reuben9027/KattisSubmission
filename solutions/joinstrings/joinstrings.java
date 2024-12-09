import java.util.*;
import java.util.Formatter.BigDecimalLayoutForm;
import java.lang.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.GuardedObject;
import java.io.*;

class StringStack {
    String str;
    Queue<StringStack> dq = new ArrayDeque<>();

    void solve() {
        System.out.print(str);
        while (!dq.isEmpty()) {
            dq.poll().solve();
        }
    }

    StringStack(String str) {
        this.str = str;
    }
}

public class joinstrings {
    static HashMap<String, Integer> hash = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringStack[] arr = new StringStack[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new StringStack(br.readLine());
        }

        StringStack last = arr[n - 1];
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer strTok = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(strTok.nextToken()) - 1;
            int b = Integer.parseInt(strTok.nextToken()) - 1;
            arr[a].dq.add(arr[b]);
            last = arr[a];
        }
        last.solve();
    }
}
