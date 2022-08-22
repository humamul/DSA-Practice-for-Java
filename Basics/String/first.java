// concatenation and reversing of a string.
// given String S1,String S2
return new StringBuilder(S1+S2).reverse().toString();


Another Question
// When you have to count the Uppercase letter in a String then you can use Character.isUpperCase(// inside this you can use char like );
   int countCamelCase (String s)
    {
   int count =0;
   for(int i=0;i<s.length();i++){
       if(Character.isUpperCase(s.charAt(i))){
          
           count++;
       }
   }
   return count; // your code here        
    }
