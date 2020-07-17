package _5._1;

public class QuickSort3Way {

    public static int R = 256;
    public static void main(String[] args) {
        String[] arr = new String[]{"Laasya", "Yogith", "Lavanya", "Durga"};
        sort(arr, 0, 3, 0);
        for(String s: arr){
            System.out.println(s);
        }
    }

    public static void sort(String[] arr, int lo, int hi, int idx){
        if(lo >= hi)
            return;
        int pivot = arr[hi-lo/2].charAt(idx);
        int[] count = new int[4];
        for(int i=lo; i< hi; i++ ){
            if(arr[i].charAt(i) < pivot) {
                count[1]++;
            }else if(arr[i].charAt(i) == pivot) {
                count[2]++;
            }else if(arr[i].charAt(i) == pivot) {
                count[3]++;
            }
        }
        for(int i=0; i< 3; i++ ){
            count[i+1] += count[i];
        }
        for(int i=0 ;i < 3; i++){
            sort(arr, lo + count[i] , lo + count[i+1] -1, idx++);
        }
    }
}
