package Question1;
// minimum cost to go upstairs  leetcode 746'
import java.util.Arrays;

public class leet746 {
    public static void main(String[] args) {
        int[] cost = {10,15,20};
        int n = 3;
       int x = solve(cost,n);
        System.out.println(x);
    }
    static int solve(int[] cost,int n){
        int x = n+1;
        int[] dp = new int[x];
        Arrays.fill(dp,-1);
        dp[0] = cost[0];
         dp[1] = cost[1];

        // 2 -> n-1
        for(int i=2;i<n;i++){
            dp[i] = cost[i] + Math.min(dp[i-1],dp[i-2]);

        }
//        return x;
         return Math.min(dp[n-1],dp[n-2]);
    }
}
