class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n =weights.length;
        int low =0;
        int high = 0;
        for(int i=0;i<n;i++){
            low = Math.max(low,weights[i]);
            high = high + weights[i];
        }  
        while(low<high){
            int mid = low + (high-low)/2;
            if(canShip(weights, mid, days)){
                high = mid;
            }else{
                low = mid+1;
            }
        } 
        return low;           
    }
    private boolean canShip(int weights[], int mid, int days){
        int curr_load = 0;
        int daysUsed = 1;
        for(int i=0;i<weights.length;i++){
            if(curr_load + weights[i] <= mid){
                curr_load += weights[i];
            }else{
                daysUsed++;
                curr_load = weights[i];
            }
        }
        return daysUsed<=days;
    }
}