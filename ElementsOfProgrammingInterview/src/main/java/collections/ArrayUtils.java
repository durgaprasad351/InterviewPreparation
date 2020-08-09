package collections;

public class ArrayUtils {

    public static void swap(int[] a, int m, int p) {
        if(m == p) return;
        int tmp = a[p];
        a[p] = a[m];
        a[m] = tmp;
    }
}
