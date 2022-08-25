package Aditya;

public class Question2 {
    public static void main(String[] args) {

        int[] arr = { 3, 34, 4, 12, 5, 2};
        int sum = 38;
        boolean x =  solveT(arr,sum,arr.length);
      boolean x1 =  solve(arr, sum,arr.length);
        System.out.println(x);
        System.out.println(x1);
    }
    static boolean solveT(int[] arr,int s , int n){
        boolean [] [] dp = new boolean[n+1][s+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<s+1;j++){

                if(i==0){
                    dp[i][j] = false;
                }
                if(j==0){
                    dp[i][j] = true;
                }


            }
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<s+1;j++){
                if(arr[i-1]<= j)
                dp[i][j] = dp[i-1][j-arr[i-1]] | dp[i-1][j];
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
//        System.out.println(dp[n][s]);
        return dp[n][s];
    }
    static boolean solve(int[] arr , int s,int n){
        if(s==0) return true;
        if(n==0 && s!=0) return false;


        return  solve(arr, s-arr[n-1],n-1) || solve(arr, s, n-1);

    }
}
