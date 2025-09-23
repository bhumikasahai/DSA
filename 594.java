class Solution {
    public int findLHS(int[] nums) {
        int count = 0;
        int n = nums.length;
        int i = 0, j = 0;
        Arrays.sort(nums);
        while (j < n) {
            if (Math.abs(nums[j] - nums[i]) == 1) { 
                count = Math.max(count, j - i + 1);
                j++;
            }else if(Math.abs(nums[j] - nums[i]) < 1){
                j++;
            }else{
                i++;
            }
        }
        return count;
    }
}
