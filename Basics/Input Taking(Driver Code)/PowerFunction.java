Find the number of ways that a given integer, X, can be expressed as the sum of the Nth powers of unique, natural numbers.




import java.util.*;
import java.io.*;
import java.util.stream.*;

class Main{
  

public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String s = br.readLine();
      String[] sarr = s.split(" ");
    
    int x = Integer.parseInt(sarr[0]);
    int n = Integer.parseInt(sarr[1]);    
     
    int q = solve (x,n,1);
 
    System.out.println(q);
}
 
 static int solve(int sum,int n , int b){
     
     int z = (int) Math.pow(b,n);
     
     if(sum-z==0) 
     return 1;
     if(sum-z<0){
         return 0;
     }
     
     return solve(sum-z,n,b+1)+solve(sum,n,b+1);
     
 }
}
