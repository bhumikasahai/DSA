class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        for(int i=0;i<=60;i++){
            long diff = (long) num1 - (long) i * num2;
            if (diff >= i && Long.bitCount(diff) <= i) {
                return i;
            }
        }
        return -1;
    }
}