/*
 * 2559. Medium: Count Vowel Strings in Ranges
 * https://leetcode.com/problems/count-vowel-strings-in-ranges/submissions/1495813364/?envType=daily-question&envId=2025-01-03
 * 
 */

public class M2559_CountVowelStringsInRanges {

    public int[] vowelStrings(String[] words, int[][] queries) {
     
        int[][] counts = new int[words.length][2];

        int currCount = 0;

        for (int i = 0; i < words.length; i++) {
        
            char[] currWord = words[i].toCharArray();

            if(isVowelBySwitch(currWord[0]) && isVowelBySwitch(currWord[currWord.length - 1])){
                currCount++;
                counts[i] = new int[]{1, currCount};
            }
            else{
                counts[i] = new int[]{0, currCount};
            }
        }

        int[] out = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            
            int left_index = queries[i][0];
            int right_index = queries[i][1];

            if(counts[left_index][0] == 0){

                out[i] = counts[right_index][1] - counts[left_index][1];

            }
            else{

                out[i] = counts[right_index][1] - counts[left_index][1] + 1;

            }
        }

        return out;

    }

    private boolean isVowelBySwitch(char c) {
        switch (c) {
            case 'a':            
            case 'e':           
            case 'i':           
            case 'o':            
            case 'u':            
            case 'A':
            case 'E':            
            case 'I':           
            case 'O':            
            case 'U':
                return true;
            default:
                return false;
        }
    }


}
