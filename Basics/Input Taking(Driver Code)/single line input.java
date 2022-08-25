  public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String s = br.readLine();
      String[] sarr = s.split(" ");
    
//       int[] arr = Stream.of(sarr).mapToInt(i->{
//         return Integer.parseInt(); }).toArray();
      
    
    
      List<Integer> narr = Stream.of(sarr).map(i->{
          return Integer.parseInt(i);
      }).collect(Collectors.toList());
            narr.add(-1);
            
            // System.out.println(Arrays.toString(narr));
            System.out.println(narr.size());

            
            // solve(narr,narr.length);
    }



import java.util.*;
import java.io.*;
import java.util.stream;
