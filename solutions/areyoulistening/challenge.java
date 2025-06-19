import java.util.*;

class Node {
    double x = 0;
    double y = 0;
    double r = 0;

    Node(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    // this node's pov
    double relativeDistance(Node n) {
        double dY = Math.abs(this.y - n.y);
        double dX = Math.abs(this.x - n.x);
        double hypot = Math.hypot(dX, dY);
        return hypot - this.r;
    }
}

public class challenge {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double x = s.nextDouble();
        double y = s.nextDouble();
        Node nodeMain = new Node(x, y, 0);
        int n = s.nextInt();

        double[] list = new double[n];
        for (int i = 0; i < n; i++) {
            Node k = new Node(s.nextDouble(), s.nextDouble(), s.nextDouble());
            list[i] = k.relativeDistance(nodeMain);
        }
        Arrays.sort(list);
        System.out.printf("%.0f", Math.max(0, Math.floor(list[2])));

    }

}