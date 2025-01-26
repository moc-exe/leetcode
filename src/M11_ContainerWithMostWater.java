/*
 * Medium 11: Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/?envType=study-plan-v2&envId=leetcode-75
 * 
*/
public class M11_ContainerWithMostWater {
    public int maxArea(int[] height) {
     
        int len = height.length;
        int i = 0, j = len - 1;
        int maxVol = 0;

        while (i < j){

            int currVol = (j - i) * Math.min(height[i], height[j]);
            maxVol = currVol > maxVol ? currVol : maxVol;
            
            if(height[i] > height[j]){
                j--;
            }
            else{
                i++;
            }
        }

        return maxVol;

    }
}
