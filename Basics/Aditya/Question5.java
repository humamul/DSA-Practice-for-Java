package Aditya;

public class Question5 {

    public static void main(String[] args) {
        String s = "abcde";
        String s2 = "adbce";
        int l = s.length();
        int l2 = s2.length();
        int [] [] dp = new int[l+1][l2+1];
        for(int i=0;i<l+1;i++){
            for(int j=0;j<l2+1;j++){

                if(i==0||j==0){
                    dp[i][j] = 0;
                }
                else{
                    dp[i][j] = -1;
                }


            }
        }

        System.out.println(s.charAt(0 )== s2.charAt(0));
     int x =    check(s,s2,l,l2,dp);
        System.out.println(x);
    }
    static int check(String s1,String s2 ,int l,int l2,int[][]dp){

        if(l==0 || l2 ==0) return 0;

        if(dp[l][l2]!=-1) return dp[l][l2];
        if(s1.charAt(l-1)==s2.charAt(l2-1)){

            dp[l][l2]= 1+check(s1,s2,l-1,l2-1,dp);
            return dp[l][l2];
        }
        else {
            return dp[l][l2] = Math.max(check(s1,s2,l-1,l2,dp),check(s1,s2,l,l2-1,dp));
//                    +check(s1,s2,l-1,l2-1);
        }

    }
}
