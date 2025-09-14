class Solution {
    public int longestOnes(int[] nums, int k) {
    int i=0;
    int j=0;
    int count=0;
    int length = 0;
    int len = 0;
        while(j<nums.length){
            if(nums[j]==0){
                count++;
            }
            j++;
            len++;
            while(count>k){
                if(nums[i]==0){
                    count--;
                }
                i++;
                len--;
            }
            length = Math.max(length,len);
        }
        return length; 
    }
}
