/*
* https://leetcode.com/problems/single-number/
*
* Single Number 
*
* Single Number Total Accepted: 68127 Total Submissions: 150383 My Submissions Question Solution 
* Given an array of integers, every element appears twice except for one. Find that single one.
* 
* Note:
* Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*
*/


public class SingleNumber {

  public static int singleNumber(int[] nums) {
    int sum = 0;

    for (int i = 0; i < nums.length; i++ ){
    
       sum ^= nums[i];
    }
    return sum;
  
  
  }


  public static void main(String args[]){
  
      int[] nums=new int[]{1,2,2};
      System.out.println(SingleNumber.singleNumber(nums));
  }

}