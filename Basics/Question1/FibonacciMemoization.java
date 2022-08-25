package Question1;

import java.util.Arrays;

public class FibonacciMemoization {

    public static void main(String[] args) {
        int n = 6;
      int[] dp = new int[n+1];

        Arrays.fill(dp,-1);  // IMPORTANT;;

//        int x = getFib(n,dp);         // tab
        int x = getFib(n-1,dp); //memoization
        System.out.println(x);

    }
    public static int getFib(int n, int[] dp){
//        dp[0] = 0;
//        dp[1] = 1;
//
//        for(int i=2;i<n;i++){
//            dp[i] = dp[i-1] + dp[i-2];
//        }
//
//        return dp[n-1];

        if(n<=1) return n;
        if(dp[n] !=-1){
            return dp[n];

        }
        else{
            dp[n] =  getFib(n-1,dp) + getFib(n-2,dp);
            return  dp[n];
        }


    }
}
