import java.util.*;
import java.io.*;
import java.util.stream.Collectors.*;
import java.util.stream.*;
// import java.io.*;
class Main{
    
    
    public static void main(String[] args) throws IOException{
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
       
        LinkedList<Integer> l1 = new LinkedList<>();
        // LinkedList<Integer> l2 = Stream.of(s.nextLine().trim().split(" ")).map(Integer::parseInt).collect(Collectors.toCollection(LinkedList::new));
        
        for(int i=0;i<n;i++){
            l1.add(s.nextInt());
        }
//   System.out.println(l1);
  
  LinkedList<int[]> stack = new LinkedList<>();
  LinkedList<int[]> a1 = new LinkedList<>();
  
  for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && stack.getLast()[0]<=l1.get(i)){
                stack.removeLast();
            }
            if(stack.isEmpty()){
                a1.add(new int[] {-1,-1});
            }
            else{
                a1.add(stack.getLast());
            }
            stack.add(new int[]{l1.get(i),i});
        }
        
        Collections.reverse(a1);
      
         LinkedList<int[]> stack1 = new LinkedList<>();
  LinkedList<int[]> a2 = new LinkedList<>();
  
        
        for(int i=n-1;i>=0;i--){
            while(!stack1.isEmpty() && stack1.getLast()[0]>=l1.get(i)){
                stack1.removeLast();
            }
            if(stack1.isEmpty()){
                a2.add(new int[] {-1,-1});
            }
            else{
                a2.add(stack1.getLast());
            }
            stack1.add(new int[]{l1.get(i),i});
        }
        
        Collections.reverse(a2);

        // for(int i=0;i<a2.size();i++){
        // System.out.println(a2.get(i)[0]+" "+a2.get(i)[1]);

        // }
        
        
        for(int i=0;i<a1.size();i++){
            if(a1.get(i)[1]<0)
            System.out.print(-1+" ");
            else{
            System.out.print(a2.get(a1.get(i)[1])[0]+ " ");

            }
        }
   }

}
