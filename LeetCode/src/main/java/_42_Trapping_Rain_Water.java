public class _42_Trapping_Rain_Water {

    public static void main(String[] args) {
        System.out.println( trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}) == 6 );

        System.out.println( trap(new int[]{0,1,0,2,0,3,0,4,0,5,0,6}) == 15 );

        System.out.println( trap(new int[]{0,1,0,2,0,3,0,4,0,3,0,2,0,1}) == 12 );

        System.out.println( trap(new int[]{0,1,0,2,1,1,3,2,1,1,4}) == 8 );

        System.out.println( trap(new int[]{0}) == 0 );
        System.out.println( trap(new int[]{0,1}) == 0 );
        System.out.println( trap(new int[]{0,1,0}) == 0 );
    }

    public static int trap(int[] height) {
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        int n = height.length -1;
        maxLeft[0] = height[0];
        int maxSoFar = height[0];
        for(int i = 1; i<= n ;i++){
            if(height[i] > maxSoFar){
                maxSoFar = height[i];
            }
            maxLeft[i] = maxSoFar;
        }
        maxRight[n] = height[n];
        maxSoFar = height[n];
        for(int i = n-1; i> -1 ;i--){
            if(height[i] > maxSoFar){
                maxSoFar = height[i];
            }
            maxRight[i] = maxSoFar;
        }
        int t =0;
         for(int i=0; i<= n; i++){
              t += Math.min( maxLeft[i], maxRight[i]) - height[i];
         }
        return t;
    }

}
