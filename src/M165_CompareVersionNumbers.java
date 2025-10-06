public class M165_CompareVersionNumbers {
    
    class Solution {

        public int compareVersion(String version1, String version2) {
            
            String regex = "\\.";
            String[] matchedV1Arr = version1.split(regex, 0);
            String[] matchedV2Arr = version2.split(regex, 0);

            int maxLen = Math.max(matchedV1Arr.length, matchedV2Arr.length);
            int[] v1 = new int[maxLen];
            int[] v2 = new int[maxLen];

            for(int i = 0; i < matchedV1Arr.length; i++){
            
                v1[i] = Integer.parseInt(matchedV1Arr[i]);

            }
            for(int i = 0; i < matchedV2Arr.length; i++){
            
                v2[i] = Integer.parseInt(matchedV2Arr[i]);

            }

            int i = 0;
            boolean done = false;

            while(!done && i < maxLen){

                if(v1[i] == v2[i]){i++; continue;}
                else if(v1[i] < v2[i]){return -1;}
                else{
                    return 1;
                }





            }

            return 0; // same ver


            




        }
    
    }

}
