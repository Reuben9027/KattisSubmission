import java.util.*;


class MonPath{
    long length;
    Mon next;

    MonPath(Mon n, long l){
        this.length = l;
        this.next = n;
    }
}

class Mon{
    static int counter=  0;
    static int counter2= 0;
    static HashSet<Mon> hash = new HashSet<>();

    static long [] hashTSP = new long[ 1<<16];
    // static HashMap<Long, Long> hashTSP = new HashMap<>();
    static int lastKey = 0;

    static{
        Arrays.fill(hashTSP, -1);
    }
    // HashMap<Integer, Long> localTSP = new HashMap<>();
    long [] localTSP = new long[1<<16];

    ArrayList<MonPath> list = new ArrayList<>();
    ArrayList<MonPath> list2=  new ArrayList<>();

    long value;
    int index;
    long path[];

    //mst
    void check( Mon parent, long length){
        if (hash.contains(this)) {
            return;
        }
        counter2 ++;
        hash.add(this);

        if (parent.path[this.index] <= length) {
            hash.remove(this);
            return;
        }
        parent.path[this.index] = length; 
        for(MonPath mp : list){
            mp.next.check(parent, length + mp.length);
        }
        hash.remove(this);
    }

    void tsp(int bitmask,long length){
        if (hashTSP[bitmask] == -1) {
            hashTSP[bitmask] = length;
        }else if (localTSP[bitmask] != -1) {
            if (localTSP[bitmask] <= length  ) {
                return;
            }
        }

        if (hashTSP[bitmask]> length) {
            hashTSP[bitmask] = length;
        }
        if (hashTSP[lastKey] !=-1 && hashTSP[lastKey] <= length) {
            return;
        }
        localTSP[bitmask]=length;
        counter++;
        
        //hashTSP.put(bitmask, length);

        for(MonPath mp : list2){
            if(mp.length == 0){
                continue;
            }
            int cBitmask = (bitmask& (1<<mp.next.index));
            if (cBitmask != 0) {
                continue;
            }
            int nBitmask =  (bitmask| (1<<mp.next.index));
            mp.next.tsp(nBitmask, length + mp.length);
        }
    }


    Mon(long value, int index, int size){
        this.value = value;
        this.index = index;
        this.path = new long[size];

        Arrays.fill(this.path , Long.MAX_VALUE);
        Arrays.fill(this.localTSP, -1);

    }
}

class Comp implements Comparator<MonPath>{
    @Override
    public int compare(MonPath a, MonPath b){
        return Long.compare(a.length , b.length);
    }
}


public class challenge {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        

        int n =s.nextInt();
        int m =s.nextInt();
        int k  = s.nextInt();

        Mon[] arr=  new Mon[n];
        long[] arr2=  new long[n];
        int key = (0xFFFF)>>>(16-n);
        Mon.lastKey = key;

        for(int i = 0; i< n; i++){
            long val = s.nextLong();
            arr[i] = new Mon(val, i, n);
            arr2[i] = val;
        }

        for(int i = 0; i< m; i++){
            Mon a = arr[s.nextInt() -1];
            Mon b = arr[s.nextInt()-1];
            int c = s.nextInt();

            MonPath p1 = new MonPath(b, c);
            MonPath p2 = new MonPath(a, c);

            a.list.add(p1);
            b.list.add(p2);

        }
    
        
        for(int i = 0; i< n; i++){
            arr[i].check(arr[i], 0);
        }

        
        for(Mon p : arr){
            for(int i = 0; i< p.path.length; i++){
                long j = p.path[i];
                p.list2.add(new MonPath(arr[i], j));
            }
            p.list2.sort(new Comp());
        }
        
        Arrays.sort(arr2);
        long result  = 0;
        for(int i = 0; i< n-k; i++){
            result += arr2[i];
        }

        Mon.hash.clear();
        arr[0].tsp(1, 0);


        System.out.println(Mon.hashTSP[key]+ result);
    }
}