import java.util.ArrayList;

public class E696_CountBInarySubstrings {
    class Solution {
        public int countBinarySubstrings(String s) {
            
            int curr = 0;
            char[] tokens = s.toCharArray();
            int len = s.length();
            
            var indicesListZeroOne = new ArrayList<Integer>();
            var indicesListOneZero = new ArrayList<Integer>();
            
            while(curr != -1){
                curr = s.indexOf("01", curr);
                if(curr != -1){
                    indicesListZeroOne.add(curr);
                    curr++;
                }
            }

            curr = 0;
            while(curr != -1){
                curr = s.indexOf("10", curr);
                if(curr != -1){
                    indicesListOneZero.add(curr);
                    curr++;

                }
            }

            int count = 0;

            for (int idx : indicesListZeroOne) {
                
                int left = idx;
                int right = idx+1;
                while(left >= 0 && right < len){

                    if(tokens[left] == '0' && tokens[right] =='1'){
                        count++;
                        left--;
                        right++;
                        continue;
                    }
                    break;
                }
            }
            for (int idx : indicesListOneZero) {
                
                int left = idx;
                int right = idx+1;
                while(left >= 0 && right < len){

                    if(tokens[left] == '1' && tokens[right] =='0'){
                        count++;
                        left--;
                        right++;
                        continue;
                    }
                    break;
                }
            }
            return count;

        }
    }
}
