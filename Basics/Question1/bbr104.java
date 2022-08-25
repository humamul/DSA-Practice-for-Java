package Question1;

import java.util.ArrayList;
import java.util.Arrays;

public class bbr104 {
    public static void main(String[] args) {
       int[] coin = {1,2,3};
       int x = 7;

       int[] dp = new int[x+1];
        Arrays.fill(dp,-1);


      int t=  memoization(coin,x,dp);
      if(t!=Integer.MAX_VALUE) System.out.println(t);
      else System.out.println(-1);

    }
    public static int memoization(int[] coin, int x,int[] dp){

        if(x == 0) return 0;
        if(x<0) return Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<coin.length;i++){
            int ans = memoization(coin,x-coin[i],dp);
            if(ans!=Integer.MAX_VALUE) {
                min = Math.min(min,ans+1);
            }
        }

        dp[x] = min;
        return min;


    }
}
