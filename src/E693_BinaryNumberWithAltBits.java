public class E693_BinaryNumberWithAltBits {
 
    class Solution {
        public boolean hasAlternatingBits(int n) {

            String input = Integer.toBinaryString(n);

            StringBuilder sb = new StringBuilder();
            boolean isOne = true; // starts from 1 ... 
            for (int i = 0; i < input.length(); i++) {
                sb.append(isOne ? '1' : '0');
                isOne = !isOne; // flip
            }

            return input.equals(sb.toString());


        }
    }
}
