import java.util.*;
import java.util.stream.*;
import java.io.*;
class Main{
    public static void main(String[] args){
        Scanner s = new Scanner (System.in);
        int n = s.nextInt();s.nextLine();
        String str = s.nextLine();
        char[] arr = str.toCharArray();
        List<Character> l = new LinkedList<>();
       StringBuilder sb = new StringBuilder();
        solve(arr,l,0,sb);
    }
   static void solve(char[] arr,List<Character> l,int in,StringBuilder sb){
        if(sb.length()!=0){
            System.out.println(sb.toString());
        }
        
        for(int i=in;i<arr.length;i++){
            sb.append(arr[i]);
            solve(arr,l,i+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}

Input:
4
abcd 


Output:
a
ab
abc
abcd
abd
ac
acd
ad
b
bc
bcd
bd
c
cd
d
