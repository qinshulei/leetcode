/*
*
* Single Number II Total Accepted: 48298 Total Submissions: 138651 My Submissions Question Solution 
* Given an array of integers, every element appears three times except for one. Find that single one.
* 
* Note:
* Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/

/**
 * 解题思路 实在是不会写啊T_T
 * http://www.acmerblog.com/leetcode-single-number-ii-5394.html
 */


public class SingleNumber2 {
    public int singleNumber(int[] nums) {
     int once = nums[0];
     int twice = 0;

   for(int i = 1; i<nums.length; i++){
      int last_once = once;
      int last_twice = twice;
      int add_on_twice = last_twice & nums[i];  
      twice = last_twice & ~add_on_twice;
      int add_on_once =  nums[i] & ~add_on_twice ;
      int new_to_twice = last_once & add_on_once ;
      twice |= new_to_twice;
      
      once = (last_once & ~new_to_twice) | ( nums[i] & ~add_on_twice & ~new_to_twice);
   }
   
   
   
   
    return once;
      
        
    }
    
    
    public static void main(String[] args){
      SingleNumber2 s2=new SingleNumber2 ();
      int[] a = new int[]{1,15,15,15,1,12,1};
      System.out.println(s2.singleNumber(a));
    }
}    
