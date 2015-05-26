import java.lang.Math;
public class Solution {
    //f(n+1)=max(rob(n+1),unrob(f(n+1)))=max(unrob(n)+n,unrob(f(n+1))=max(unrob(n)+n,rob(fn))
    //nums = 10,100,10
    //f(3)=max(rob(3),unrob(3))=max(ubrob(2)+10,f(2))=max(f(1)+10,f(2))=max(10+10,max(f0)=100
    //so -> f(n)=max(f(n-2)+nums[n],f(n-1))
    public int rob(int[] nums) {
        if(nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        // int f2 = Math.max(nums[0],nums[1]);
        int prepre = nums[0];
        int pre = Math.max(nums[0], nums[1]);
        int cur = pre;
        for(int i=2; i<nums.length; i++)
            {
                cur = Math.max(prepre+nums[i],pre);
                prepre = pre;
                pre = cur;
            }
        return cur;

    }
}
