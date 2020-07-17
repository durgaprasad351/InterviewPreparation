package _5._1;

public class KyIndexedCounting {

    public static void main(String[] args) {
        Tuple[]  tuples = new Tuple[]{
                new Tuple(2, "Anderson" ),
                new Tuple(3, "Brown" ),
                new Tuple(3, "Davis" ),
                new Tuple(4, "Garcia" ),
                new Tuple(1, "Harris" ),
                new Tuple(3, "Jackson" ),
                new Tuple(4, "Johnson" ),
        };
        keyIndexSorting( tuples, 5 );
    }

    public static void keyIndexSorting(Tuple[]  a, int R){
        int n = a.length;
        Tuple[] aux = new Tuple[n];
        int[] count = new int[R+1];

        for(int i=0; i< n; i++){
            count[a[i].key +1] ++;
        }
        for(int r=0; r< R; r++){
            count[r+1] += count[r];
        }
        for(int i=0; i<n;i++){
            aux[count[a[i].key]++] = a[i];
        }
        for(int i=0; i< n; i++){
            System.out.print( " "  + aux[i].val );
        }
    }

    static class Tuple{
        public int key;
        public String val;
        public  Tuple(int key, String val){
            this.key = key;
            this.val = val;
        }
    }

}
