class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=0;
        for(int i=0;i<piles.length;i++){
            high = Math.max(high,piles[i]);
        }
        while (low <= high) {
            int mid = low + (high - low) / 2; 
            if (canEat(piles, mid, h)) {        
                high = mid - 1;
            } else {
                low = mid + 1;   
            }
        }
        return low;
    }
    private boolean canEat(int piles[],int speed,int h){
        long totalHours = 0;
         for (int bananas : piles) {
            totalHours += (bananas + speed - 1) / speed;
            if (totalHours > h) return false;
        }
        return totalHours <= h;
    }
}