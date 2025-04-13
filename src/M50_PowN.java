public class M50_PowN {
    public double myPow(double x, long n) {
        
        if(x == 1){
            return 1;
        }
        if(x == 0){
            return 0;
        }

        if(n < 0){

            double result = myPow(x, -(long)n);
            return 1 / result;
        }

        if(n == 0){return 1;}

        double tempResult = myPow(x, n/2);
        double result = tempResult * tempResult;
        if(n % 2 == 1){

            result *= x;

        }

        return result;
    }
}
