class Solution {
    public int minImpossibleOR(int[] nums) {
        Arrays.sort(nums);
		int minXOR = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > minXOR + 1) {
				return minXOR + 1;
			}
			minXOR |= nums[i];
		}
		return minXOR + 1;
    }
}