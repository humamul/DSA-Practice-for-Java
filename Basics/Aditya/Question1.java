package Aditya;

public class Question1 {
    public static void main(String[] args) {
        int[]  wt = {1,3,4,5};
        int[] v = {1,4,5,7};

        int c = 7;   // capacity;
        int n = wt.length;


       int[][] dp = new int[n+1][c+1];
       for(int i=0;i<n+1;i++){
           for(int j=0;j<c+1;j++){
               dp[i][j] = -1;
           }
       }
        int x= snap(wt,v,c,n,dp);
        System.out.println(x);
    }
    public static int snap(int[] wt,int[] val,int c,int n,int[][] dp){

        if(c==0 || n==0) return 0;

        if(dp[n][c]!=-1){
            return dp[n][c];
        }

        if(wt[n-1]<=c){
            dp[n][c] =  Math.max(val[n-1] + snap(wt, val, c-wt[n-1], n-1,dp),snap(wt, val, c, n-1,dp));
        }else{
            dp[n][c]= snap(wt, val, c, n-1,dp);
        }
        return dp[n][c];
    }
}
