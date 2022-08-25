package Question1;

public class FibonacciNormal {
    public static void main(String[] args) {
        int n = 5;
       int z = getFib(n-1);
        System.out.println(z);
    }
     public static int getFib(int n){
        if(n==0 | n==1) return n;
        return getFib(n-1) + getFib(n-2);
    }
}
