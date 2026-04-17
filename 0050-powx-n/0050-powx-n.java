class Solution {
    public double myPow(double x, long n) {
        if(n == 0){
            return 1.0;
        }
        boolean negative = false;
        if(n < 0){
            n = -n;
            negative = true;
        }

        double result;        
        double target = myPow(x, n / 2);
        if(n % 2 == 1){
            result = x * target * target;
        } else {
            result = target * target;
        }
        
        if(negative){
            return 1 / result;
        } else {
            return result;
        }
    }
}