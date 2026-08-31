class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int totalDrunk = 0;
        int empty = 0;
        int full = numBottles;
        while (full > 0) {
            totalDrunk += full;
            empty += full;
            full = 0;
            if (empty >= numExchange) {
                full = 1; 
                empty -= numExchange;
                numExchange++; 
            } else {
                break;
            }
        }
        return totalDrunk;        
    }
}