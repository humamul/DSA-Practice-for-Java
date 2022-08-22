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


// you can convert Whole String str to upper case;
Str.toUpperCase();





Q3
// Input:
// S = "#GeeKs01fOr@gEEks07"
// Output:
// 5
// 8
// 4
// 2
// Explanation: There are 5 uppercase characters,
// 8 lowercase characters, 4 numeric characters
// and 2 special characters.


class Sol
{
    int[] count (String s)
    {
       int l=0,u=0,sc=0,n=0;
       
        for(int i=0;i<s.length();i++){
            if(Character.isUpperCase(s.charAt(i))) u++;
            else if(Character.isLowerCase(s.charAt(i))) l++;
            else if(Character.isDigit(s.charAt(i))) n++;
            else sc++;
        }
        
        int[] sa= {u,l,n,sc};
        return sa;
    }
}
