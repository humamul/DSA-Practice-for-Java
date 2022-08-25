import java.util.*;
import java.io.*;
import java.util.stream.*;
import java.util.stream.Collectors.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        
        for(int i=0;i<t;i++){
      int n = Integer.parseInt(br.readLine());
      List<Integer> l1 = Stream.of(br.readLine().trim().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
      solve(l1,n);
        }
    }
    
}
