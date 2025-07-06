import java.util.*;



public class challenge {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String k= s.next();

        Deque<Character>pq = new ArrayDeque<>();
        Deque<Character>pq2 = new ArrayDeque<>();
        for(int i = 0; i< k.length(); i++){
            char c = k.charAt(i);
            try {
                switch (c) {
                    case 'L':
                        pq2.addFirst(pq.pollLast());
                        break;
                    case 'R':
                        pq.addLast(pq2.pollFirst());
                        break;
                    case 'B':
                        pq.pollLast();
                        break;
                    default:
                        pq.add(c);
                        break;
                }    
            } catch (Exception e) {
                // e.printStackTrace();
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            sb.append(pq.poll());
        }

        while(!pq2.isEmpty()){
            sb.append(pq2.poll());
        }
        System.out.println(sb.toString());
    }
}