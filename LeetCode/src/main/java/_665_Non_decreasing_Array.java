public class _665_Non_decreasing_Array {

    public static void main(String[] args) {
        System.out.println( checkPossibility(new int[]{3,4,2,3}) == false);

        System.out.println( checkPossibility(new int[]{4,2,3}) == true);

        System.out.println( checkPossibility(new int[]{4,2,1}) == false);

        System.out.println( checkPossibility(new int[]{2,3,3,2,4}) == true);

        System.out.println( checkPossibility(new int[]{4}) == true);
    }

    public static boolean checkPossibility(int[] a) {
        int fails = 0;
        int n = a.length -1;
        for(int i=0; i<= n; i++){
           if( (i+1) <=n && a[i] > a[i+1]){
               fails ++;
               if((i-1) >= 0  && (i+2) <= n){
                   if( !(a[i] < a[i+2]  || a[i-1] < a[i+1])){
                     fails++;
                   }
               }
           }
        }
        return fails <= 1;
    }
}
