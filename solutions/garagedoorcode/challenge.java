    import java.io.*;
    import java.util.*;


    class Str{
        String k  = "";
        int quan = 0;
        Str(String k){
            this.k= k;
        }
    }

    class Comp implements Comparator<Str>{
        @Override
        public int compare(Str a, Str b){
            int r = Integer.compare(b.quan, a.quan);
            if(r ==0){
                return a.k.compareTo(b.k);
            }
            return r;
        }
    }
    class challenge{
        static HashMap<String,Str> hash = new HashMap<>();
        static HashMap<String, HashSet<String>> hash2 = new HashMap<>();
        static String str ="";
        static StringBuilder sb =new StringBuilder();
        static int m= 0;
        static int max=0;

        static void subs(int p){
            try {
                if(sb.length()==m){
                    String k = sb.toString();
                    if(!hash.containsKey(k)){
                        hash.put(k,new Str(k));
                    }
                    if(!hash2.containsKey(str)){
                        hash2.put(str, new HashSet<>());
                    }
                    hash2.get(str).add(k);
                    hash.get(k).quan++;
                    max = Math.max(hash.get(k).quan, max);
                    return;
                }
                for(int i =p; i< str.length(); i++){
                    sb.append(str.charAt(i));
                    subs(i+1);
                    sb.deleteCharAt(sb.length()-1);
                }
            } catch (Exception e) {
            }
        }
        
        public static void main(String[] args) throws IOException {
            Scanner s = new Scanner(System.in);
            m =s.nextInt();
            int n =s.nextInt();
            String []arr = new String[n];
            for(int i = 0; i< n; i++){
                str = s.next();
                arr[i] = str;
                subs(0);    
            }
            Collection <Str>col   = hash.values();
            ArrayList<Str> list = new ArrayList<>();
            for(Str k : col){
                boolean q = true;
                if(max != k.quan){
                    continue;
                }
                for(String p : arr){
                    if(!q){
                        break;
                    }
                    q&=hash2.get(p).contains(k.k);
                }
                if(q){
                    list.add(k);
                }

            }
            list.sort(new Comp());
            System.out.println(list.size());
            for(Str k : list){
                System.out.println(k.k);
            }

        }
    }
