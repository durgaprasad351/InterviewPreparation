package search;

/**
 * Find a element in a 2D array where the values are in increasing order .
 */
public class Search2DArray {
    private  static int[][] twoD =  new int[][]{
            {-1,2,4,4,6},
            {1,5,5,9,21},
            {3,6,6,9,22},
            {3,6,8,10,24},
            {6,8,9,12,25},
            {8,10,12,13,40}
    };

    public static void main(String[] args) {
        System.out.println( searchIn2DArray(twoD, 10) );
        System.out.println( searchIn2DArray(twoD, -1) );
        System.out.println( searchIn2DArray(twoD, 5 ));
    }

    public static boolean searchIn2DArray(int[][] arr,int target){
        int row = 0; int col = arr[row].length -1;
        while(row < arr.length -1 && col >= 0  ){
            int val = arr[row][col];
            if( val < target){
                row++;
            }else if(val > target){
                col--;
            }else{
                System.out.println( "Row :  " + row + "  Col :   "+ col );
                return true;
            }
        }
        return  false;
    }

}
