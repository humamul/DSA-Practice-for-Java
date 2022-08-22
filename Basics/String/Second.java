// Input:
// S = "geeksforgiiks"
// Output: giiksforgeeks
// Explanation: The vowels are: e, e, o, i, i
// Reverse of these is also i, i, o, e, e.
  
    String modify (String s)
    {
       StringBuffer str = new StringBuffer();
       
       char[] arr = s.toCharArray();
       
       for(int i=0;i<arr.length;i++){
           if(arr[i]=='a' | arr[i]=='e' | arr[i]=='i' | arr[i]=='o' | arr[i]=='u' ){
               str.append(arr[i]);
               arr[i] = '#';
               
               
           }
       }
       
       str.reverse();
       int v =0;
        for(int i=0;i<arr.length;i++){
           if(arr[i]=='#'){
             
               arr[i] = str.charAt(v++);
               
           }
       }
    //   System.out.println(arr);
    String chaca = String.valueOf(arr);
       return chaca;
       // your code here
    }
    
    
