/*
 * They said it was gonna be easy ... well it wasn't i'd say it's MID tier at best
 * https://leetcode.com/problems/can-place-flowers/submissions/1496796777/?envType=study-plan-v2&envId=leetcode-75
 * 
 */



public class E605_CanPlaceFlowers {
    
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        if(n == 0){return true;}
        if(flowerbed.length == 1){return flowerbed[0] == 0 && n == 1;}

        boolean left, right;

        for (int index = 0; index < flowerbed.length; index++) {

            if (flowerbed[index] == 0){

                // if leftmost, then no left neighbors, consider empty, else check for actual neighbors
                left = (index == 0) ? true : flowerbed[index - 1] == 0;
                
                // if rightmost, then no right neighbors, also consider empty, else check for actual neighbors
                right = (index == flowerbed.length - 1) ? true : flowerbed[index + 1] == 0;
                
                // if both left and right are empty let's plant da flower
                if(left && right){

                    flowerbed[index] = 1; // planted a flower
                    n -= 1; // so one less needed to plant
                    if (n == 0){return true;}
                }

            }
        }
        return n <= 0; // checky checky if any left to plant after we crossed the whole flowerbed
    }
}
