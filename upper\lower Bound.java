
INPUT:
5
10 1 10 3 4
4
1 10
2 9
3 4
2 2

OUTPUT:
5 2 2 0





import java.util.*;
import java.io.*;
import java.util.stream.*;
class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int t = Integer.parseInt(br.readLine());
       Arrays.sort(arr);
        // System.out.println(Arrays.toString(arr));
        for(int i=0;i<t;i++){
            String[] str  = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b =Integer.parseInt(str[1]);
            solve(a,b,arr,n);
        }
    }
    static void solve(int a,int b,int[] arr,int n){
        
        int lb = lowerBound(arr,n,a);
        
        
        
        int ub = upperBound(arr,n,b);
        
        // System.out.println(lb+" "+ub);
        
        if(true)
        System.out.print(Math.abs(ub-lb)+" ");
        else{
            System.out.print(Math.abs(n-lb)+" ");
        }
       
    }
    static int lowerBound(int[] arr,int n,int a){
        int l=0,r=n-1,lb=-1;
        while(l<=r){
            int mid = (l+r) >> 1;
            if(arr[mid]==(a)){
               lb = mid;
                r=mid-1;
            }else if(arr[mid]<a){
               
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return l;
    }
    
    static int upperBound(int[] arr, int n,int b){
         int low=0,h=n-1,up=-1;// [-8, 15, 20]  , -8
        
         while(low<=h){
            int mids = (low+h) >> 1;
            if(arr[mids]==(b)){
            //   up = mids;
                low=mids+1;
            }else if(arr[mids]<b){
               
                low=mids+1;
            }else{
                 up=mids; //1,
                h=mids-1;
            }
        }
        return h+1;
    }
    
}
