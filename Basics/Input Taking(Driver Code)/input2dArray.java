import java.util.*;
import java.io.*;
import java.util.stream.*;
import java.util.stream.Collectors.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        
        for(int i=0;i<t;i++){
        int[] x = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = x[0];
        int n = x[1];
        int k = x[2];
        
        List<List<Integer>> mat = new ArrayList<>();
        
            for(int j=0;j<m;j++){
                List<Integer> l1 = Stream.of(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
           mat.add(l1);
            }
            
            // System.out.println(mat);
        
            solve(mat,m,n,k);
                System.out.println();
        }
    }
    static void solve(List<List<Integer>> arr,int m,int n,int k){
                        

       if(k==1){
           
           for(int i=0;i<m;i++){
          if(i%2==0) {
               for(int j=0;j<n;j++){
                   System.out.print(arr.get(i).get(j)+" ");
               }
           } 
          else {
                for(int j=n-1;j>=0;j--){
                  System.out.print(arr.get(i).get(j)+" ");
              }
          }
           }
       }
       else
       {
            
           for(int i=0;i<m;i++){
               if(i%2!=0) {
               for(int j=0;j<n;j++){
                   System.out.print(arr.get(i).get(j)+" ");
               }
           } else {
                for(int j=n-1;j>=0;j--){
                   System.out.print(arr.get(i).get(j)+" ");
               }
           }
           }
           
           
       }
    }
    
}
