import java.util.*;
import java.io.*;
import java.util.stream.*;
import java.util.stream.Collectors.*;
//replaceAll\
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
     String s1 = br.readLine();
     String s2 = br.readLine();
     s2 = s2.replaceAll(" ","");
     s1 = s1.replaceAll(" ","");
    char[] c2 = s2.toCharArray();
    char[] c1 = s1.toCharArray();
    Arrays.sort(c2); Arrays.sort(c1);
    if(String.valueOf(c2).equals(String.valueOf(c1))){
        System.out.println("True");
    }else{
        System.out.println("False");
    }
// System.out.print(String.valueOf(c1));
 
    }
    
}//Enter code here
