class Solution {
    public int trailingZeroes(int n) {
        int sum = 0;
        
        sum += n / 5;
        sum += n / 25;
        sum += n / 125;
        sum += n / 625;
        sum += n / 3125;

        return sum;
    }
}