class Solution {
    public boolean canJump(int[] nums) {
        int maxIdx = 0;
        int n = nums.length;
        for(int i=0;i<=n-1;i++){
            if(i>maxIdx){
                return false;
            }
            maxIdx = Math.max(maxIdx,nums[i]+i);
        } 
        return true;       
    }
}