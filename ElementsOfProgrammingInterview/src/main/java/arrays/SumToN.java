package arrays;

public class SumToN {
    static  int totoalRecursions = 0;
    public static void main(String[] args) {
        System.out.println( sumToN(5 ));
        System.out.println(totoalRecursions);
    }

    static  int[] dp = new int[6];

    public static int sumToN(int target ){
        totoalRecursions ++;
        if(target ==0) return 1;

        if(target < 0) return 0;

        if(dp[target] != 0) return dp[target];

        int total =0;

        total += sumToN(target - 1);

        total += sumToN(target  -2);

        total += sumToN(target  -3);
        if(target >0)
        dp[target] =total;
        return total;
    }
}
