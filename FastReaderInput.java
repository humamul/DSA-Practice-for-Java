import java.util.*;
import java.lang.*;
import java.io.*;


public class Main{
	
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() {
          while (st == null || !st.hasMoreElements()){
            try { st = new StringTokenizer(br.readLine()); }
            catch (IOException e) { e.printStackTrace(); }
          }
          return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble(){ return Double.parseDouble(next()); }
        String nextLine(){
          String str = "";
          try { str = br.readLine(); }
          catch (IOException e) { e.printStackTrace(); }
          return str;
        }
    }
    
	public static void main(String args[]){

	   // Creating FastReader Class Object.
	    FastReader s = new FastReader();
        int t = s.nextInt();
        while(t-->0){
            int n = s.nextInt();
            
            int[] arr1 = new int[n];
            int[] arr2 = new int[n];
            for(int i=0;i<n;i++){
                arr1[i]=s.nextInt();
            }
            for(int i=0;i<n;i++){
                arr2[i] = s.nextInt();
            }
            solve(arr1,arr2,n);
        }
        
	}	

    static void solve(int[] arr1,int[] arr2,int n){
    
      
    }
