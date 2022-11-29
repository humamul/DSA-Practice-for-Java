//first traverse from left to right and compare or countleft how many ele will be removed then from right do the same  LC=1909;
import java.util.*;
class Solution {
    public boolean canBeIncreasing(int[] arr) {
     int lc=0,rc=0,n=arr.length;
        int pre = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>pre) pre = arr[i];
            else lc++;
        }
         pre = arr[n-1];
        for(int i=n-2;i>=0;i--){
            if(arr[i]<pre) pre = arr[i];
            else rc++;
        }
        
        return Math.min(rc,lc)<=1;
    }
}

// Example 1:

// Input: nums = [1,2,10,5,7]
// Output: true
// Explanation: By removing 10 at index 2 from nums, it becomes [1,2,5,7].
// [1,2,5,7] is strictly increasing, so return true.
// Example 2:

// Input: nums = [2,3,1,2]
// Output: false
// Explanation:
// [3,1,2] is the result of removing the element at index 0.
// [2,1,2] is the result of removing the element at index 1.
// [2,3,2] is the result of removing the element at index 2.
// [2,3,1] is the result of removing the element at index 3.
// No resulting array is strictly increasing, so return false.
// Example 3:

// Input: nums = [1,1,1]
// Output: false
// Explanation: The result of removing any element is [1,1].
// [1,1] is not strictly increasing, so return false.
