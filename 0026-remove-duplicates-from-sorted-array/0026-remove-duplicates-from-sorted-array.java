class Solution {
    public int removeDuplicates(int[] nums) {
        int rPtr = 0;
        int wPtr = 0;
        int last = -101;
        while(rPtr < nums.length){
            if(nums[rPtr] != last){
                nums[wPtr] = nums[rPtr];
                last = nums[wPtr]; 
                wPtr++;
            }
            rPtr++;
        }
        System.out.print(wPtr);
        return wPtr;    
    }
}