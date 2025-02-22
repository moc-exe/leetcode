/*
 * https://leetcode.com/problems/asteroid-collision/description/?envType=study-plan-v2&envId=leetcode-75
 * MEDIUM 735. Asteroid Collision
 */

import java.util.Stack;

public class M735_AsteroidCollision {


    public static int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();
        int len = asteroids.length;
        
        for (int i = 0; i < len; i++) {
            
            int asteroid = asteroids[i];

            if(stack.isEmpty() || noCollision(stack.peek(), asteroid)){
                stack.push(asteroid);
            }
            else{
                // so there's collision

                int prev = -1;
                boolean didRoll = false;
                while(!stack.isEmpty() && !noCollision(stack.peek(), asteroid) && Math.abs(stack.peek()) <= Math.abs(asteroid)){

                    didRoll = true;
                    prev = stack.pop();
                    if(Math.abs(prev) == Math.abs(asteroid)){break;}

                }
                if(stack.isEmpty()){

                    if(Math.abs(prev) == Math.abs(asteroid)){continue;}
                    
                    else{stack.push(asteroid);}

                }
                else{

                    if(noCollision(stack.peek(), asteroid) && didRoll && Math.abs(asteroid) > Math.abs(prev)){
                        stack.push(asteroid);
                    }


                }
            }
        }


        int size = stack.size();
        Integer[] temp = stack.toArray(new Integer[0]);
        int[] out = new int[size];
        for (int i = 0; i < temp.length; i++) {
            out[i] = temp[i];
        }
        return out;
    }

    public static boolean noCollision(int n, int m){
        
        if(n < 0 && m < 0){ return true;}
        else if(n < 0 && m > 0){return true;}
        else if(n > 0 && m > 0){return true;}
        else{
            // n > 0 and m < 0
            return false;

        }
    }

    // public static int[] asteroidCollision(int[] asteroids) {
        
    //     Stack<Integer> staccko = new Stack<>();
    //     boolean isPositive = true; 
    //     int len = asteroids.length;

    //     for (int i = 0; i < len; i++) {
            
    //         int asteroid = asteroids[i];

    //         if((isPositive && asteroid > 0) || (!isPositive && asteroid < 0)){

    //             staccko.push(asteroid);

    //         }
    //         else{

    //             boolean prevWasEqual = false; 
    //             while(!staccko.isEmpty() && Math.abs(staccko.peek()) <= Math.abs(asteroid)){
    //                 int prev = staccko.pop();
    //                 prevWasEqual = (Math.abs(prev) == Math.abs(asteroid) ? true : false);
    //             }
    //             if(staccko.isEmpty() && prevWasEqual){
    //                 continue;
    //             }
    //             else if(staccko.isEmpty()){

    //                 isPositive = !isPositive;
    //                 staccko.push(asteroid);
    //             }
        
    //         }
    //     }

    //     int size = staccko.size();
    //     Integer[] temp = staccko.toArray(new Integer[0]);
    //     int[] out = new int[size];
    //     for (int i = 0; i < temp.length; i++) {
    //         out[i] = temp[i];
    //     }

    //     return out;
    
    // }

    // public static boolean areSameSign(int n, int m){

    //     if(n > 0 && m > 0){
    //         return true;
    //     }
    //     else if(n < 0 && m < 0){
    //         return true;
    //     }
    //     else{
    //         return false;
    //     }
    // }

    public static void main(String[] args) {
        
        int[] test = new int[]{8,-8};

        System.out.println(asteroidCollision(test));


    }
}
