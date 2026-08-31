class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return countSubarrays(nums, goal) - countSubarrays(nums, goal - 1);
    }
    private int countSubarrays(int nums[], int target){
        if(target<0){
            return 0;
        }
        int i=0, j=0, sum=0, count=0;
        int n = nums.length;
        while(j<n){
            sum += nums[j];
            while(sum>target){
                sum -= nums[i];
                i++;
            }
            count += j-i+1;
            j++;
        }
        return count;
    }
}
