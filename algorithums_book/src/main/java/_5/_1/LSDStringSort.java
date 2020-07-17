package _5._1;

public class LSDStringSort {

    public static void main(String[] args) {
        lsdSort( new String[]{"Laasya", "Yogith", "Lavanya", "Durga"}, 256 );

    }

    public static void lsdSort(String[] a, int R){
        int n = a.length;
        String[] aux = new String[n];
        int[] count = new int[R+1];

        for(int k=0; k<3; k++) {
            aux = new String[n];
            count = new int[R+1];

            for (int i = 0; i < n; i++) {
                count[a[i].charAt(k) + 1]++;
            }

            for (int i = 0; i < R; i++) {
                count[i + 1] += count[i];
            }

            for (int i = 0; i < n; i++) {
                aux[count[a[i].charAt(k)]++] = a[i];
            }
            for (int i = 0; i < n; i++) {
                a[i] = aux[i];
            }


            System.out.println("");
            for (int i = 0; i < n; i++) {
                System.out.println(aux[i]);
            }
        }
    }
}
