class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double result = 1;

        while(N>0){
            if((N & 1)==1){       //if n is odd    
                result *=x;     //multiply
            }              //if even 
            x *=x;       //square
            N /=2;       //devide
        }
        return result;
    }
}