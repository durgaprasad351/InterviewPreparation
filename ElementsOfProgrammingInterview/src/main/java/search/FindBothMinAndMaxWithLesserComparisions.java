package search;

import org.omg.PortableInterceptor.INACTIVE;

public class FindBothMinAndMaxWithLesserComparisions {
    static int comparisions = 0;
    public static void main(String[] args) {
        System.out.println(  findMinMax( new int[]{1,2,3,4,5,6,7,8,9,10} ) );
        System.out.println( "Total Comp : " + comparisions  );

        comparisions = 0;
        System.out.println(  findMinMax( new int[]{3,2,5,1,2,4,8,3} ) );
        System.out.println( "Total Comp: " + comparisions  );

        comparisions = 0;
        System.out.println(  findMinMaxSimple( new int[]{1,2,3,4,5,6,7,8,9,10}  ) );
        System.out.println( "Total Comp : " + comparisions  );

        comparisions = 0;
        System.out.println(  findMinMaxSimple( new int[]{3,2,5,1,2,4,8,3} ) );
        System.out.println( "Total Comp: " + comparisions  );
    }

    /**
     * This approach uses 2(N-1) comparisions
     * @param arr
     * @return
     */
    public static MinMax findMinMaxSimple(int[] arr){
        int min = arr[0];
        int max = arr[0];
        for(int i =1 ;i <  arr.length; i++){
            if(arr[i] < min){
                comparisions ++;
                min = arr[i];
            } else if(arr[i] > max){
                comparisions  += 2;
                max = arr[i];
            }
        }
        return new MinMax( min, max );
}

    /**
     * This method uses  3 * (n-2)/2  = 3* n/2 - 1
     * @param arr
     * @return
     */
    public static MinMax findMinMax(int[] arr){
        MinMax result = MinMax.buildMinMax( arr[0], arr[1] );
        for(int i = 2; i < arr.length ; i+=2){
            result  =  MinMax.merge(  result, MinMax.buildMinMax(arr[i], arr[i+1])  );
        }
        return result;
    }

    static class MinMax{
        int min;
        int max;
        MinMax(int min, int max){
            this.min = min;
            this.max = max;
        }

        public static MinMax buildMinMax(int v1, int v2  ){
            comparisions++;
           return  v1 > v2 ? new MinMax( v2, v1 ) : new MinMax( v1, v2 );
        }

        public static MinMax merge(MinMax m1, MinMax m2){
            comparisions +=2;
              return   new MinMax(  Math.min( m1.min, m2.min ) , Math.max(m1.max, m2.max)  );
        }

        @Override public String toString() {
            return "MinMax{" +
                    "min=" + min +
                    ", max=" + max +
                    '}';
        }
    }

}
