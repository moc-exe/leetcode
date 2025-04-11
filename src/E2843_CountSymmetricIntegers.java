public class E2843_CountSymmetricIntegers {
    
    public int countSymmetricIntegers(int low, int high) {
        
        int counter = 0;

        for (int i = low; i <= high; i++) {
            
            counter = isSymmetric(i) ? counter + 1 : counter;
        }

        return counter;

    }

    public boolean isSymmetric(int n){

        char[] tokens = String.valueOf(n).toCharArray();

        if(tokens.length % 2 != 0){return false;}

        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < tokens.length / 2; i++) {
            
            leftSum += Integer.parseInt(String.valueOf(tokens[i]));
        }
        for (int i = tokens.length / 2; i < tokens.length; i++) {
            
            rightSum += Integer.parseInt(String.valueOf(tokens[i]));
        }

        return leftSum == rightSum;
    }
        




}
