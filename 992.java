class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return countSubarrays(nums, k) - countSubarrays(nums, k - 1);
    }
    private int countSubarrays(int nums[] , int k){
        int i = 0;
        int j = 0;
        int count = 0;
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (j < n) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            while (map.size() > k) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++;
            }
            count += j-i+1;
            j++;
        }
        return count;
    }
}