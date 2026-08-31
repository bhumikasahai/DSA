class Solution {
    public int maxScore(int[] cardScore, int k) {
        int lsum = 0;
        int rsum = 0;
        int maxSum = 0;
        int sum = 0;
        int n = cardScore.length;
        for(int i=0;i<k;i++){
            lsum += cardScore[i];
            maxSum = lsum;
        }
        int ridx = n-1;
        for(int i = k-1;i>=0;i--){
            lsum -= cardScore[i];
            rsum += cardScore[ridx];
            ridx --;
            maxSum = Math.max(maxSum,lsum+rsum);
        }
        return maxSum;
    }
}