class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double call = myPow(x, n/2);
        if (n < 0) {
            return 1 / myPow(x, -(n+1)) / x;
        }
        else if (n % 2 == 0) {
            return call * call;
        }
        else {
            return x*call*call;
        }
    }
}