class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length; 
        int base = 0; 
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) base += customers[i];
        }
        int sum = 0; 
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) sum += customers[i];
        }
        int maxExtra = sum;
        for (int i = minutes; i < n; i++) {
            if (grumpy[i] == 1) sum += customers[i];
            if (grumpy[i - minutes] == 1) sum -= customers[i - minutes];
            maxExtra = Math.max(maxExtra, sum);
        }
        return base + maxExtra;
    }
}
