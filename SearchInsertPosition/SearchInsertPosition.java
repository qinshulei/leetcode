/* https://leetcode.com/submissions/detail/27362965/*/

public class SearchInsertPosition{
  
  public int searchInsert(int[] nums, int target) {
    
    if (nums.length == 0){
      return 0;
    }
    
     int L  = 0,M = 0 ,R = nums.length - 1;
     while(L <= R)
     {
       M = (L+R)/2;
       if(target == nums[M]){
         return M;
       }else if(target < nums[M]){
         R = M - 1;
       }else{
         L = M + 1;
       }
       System.out.println("L---->"+L);
       System.out.println("R---->"+R);
       System.out.println("M---->"+M);
       System.out.println("=======================");
     }
     
     if(target < nums[M]){
       return M; 
       
     }else {
       
       return M+1;
     }
    
  }
  
  public static void main(String[] args){
/*    
*    Given a sorted array and a target value, return the index if the target is found. 
* If not, return the index where it would be if it were inserted in order.
*
* You may assume no duplicates in the array.
*
* Here are few examples.
* [1,3,5,6], 5 → 2
* [1,3,5,6], 2 → 1
* [1,3,5,6], 7 → 4
* [1,3,5,6], 0 → 0
*
*/    
    int[] a = new int[]{1,3,5,6};
    int[] b = new int[]{};
    int[] c = new int[]{1};
    
    int[] d = new int[]{1,3};
    SearchInsertPosition p = new SearchInsertPosition();
    
    System.out.println(p.searchInsert(a, 5));
     System.out.println(p.searchInsert(a, 2));
      System.out.println(p.searchInsert(a, 7));
       System.out.println(p.searchInsert(a, 0));
        System.out.println(p.searchInsert(b, 1));
         System.out.println(p.searchInsert(c, 0));
          System.out.println(p.searchInsert(c, 2));
          System.out.println(p.searchInsert(d, 2));
           System.out.println(p.searchInsert(c, 1));
    
    
  }
}