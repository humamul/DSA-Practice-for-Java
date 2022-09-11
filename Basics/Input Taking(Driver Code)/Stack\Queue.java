import java.util.*;
import java.io.*;
import java.util.stream.Collectors.*;
import java.util.stream.*;
// import java.io.*;
class Main{
    
    
    public static void main(String[] args) throws IOException{
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();
        LinkedList<Integer> l1 = Stream.of(s.nextLine().trim().split(" ")).map(Integer::parseInt).collect(Collectors.toCollection(LinkedList::new));
        List<Integer> l2 = Stream.of(s.nextLine().trim().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        
        // System.out.println();
                
                int a = l1.getFirst();
                 int b = l1.getLast();
                l1.addFirst(0);
                l1.addLast(100);
                System.out.println(l1);
                l1.remove();
                System.out.println(l1);
              int x = l1.pollLast();
                System.out.println(l1+" "+x);
                 int d = l1.poll();
                 System.out.println(d);
                 System.out.println(l1);
    }
}
