package Aditya;

public class Question4 {
    public static void main(String[] args) {

        int[] arr = { 1,2,3};
        int sum = 6 ;
        int x =  solveT(arr,sum,arr.length);

        System.out.println(x);

    }
    static int solve(int[]arr,int s,int n){
        if(s==0) return 1;
        if(n==0) return 0;


        return solve(arr,s-arr[n-1],n-1) + solve(arr,s,n-1);


    }
    static int solveT(int[] arr,int s , int n){
        int [] [] dp = new int[n+1][s+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<s+1;j++){

                if(i==0){
                    dp[i][j] = 0;
                }
                if(j==0){
                    dp[i][j] = 1;
                }


            }
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<s+1;j++){
                if(arr[i-1]<= j)
                    dp[i][j] = dp[i][j-arr[i-1]] + dp[i-1][j];
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
//        System.out.println(dp[n][s]);
        return dp[n][s];
    }
}
