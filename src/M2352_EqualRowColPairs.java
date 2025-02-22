/*
 * 
 * 
 * 
 * 

    2352. Equal Row and Column Pairs MEDIUM
 * https://leetcode.com/problems/equal-row-and-column-pairs/description/?envType=study-plan-v2&envId=leetcode-75
 * 
 * 
 * 
 * 
 */

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;


public class M2352_EqualRowColPairs {

    public int equalPairs(int[][] grid) {
        
        int len = grid.length;
        int counter = 0; 
        HashMap<String, Integer> map = new HashMap<>();

        // let's compute the hashcodes for all the rows and record the number of identical rows found if ever
        for (int i = 0; i < len; i++){
            
            String hash = sha256Hash(grid[i]);

            if(map.containsKey(hash)){

                int val = map.get(hash);
                map.put(hash, ++val);

            }
            else{

                map.put(hash, 1);

            }

        }

        for (int i = 0; i < len; i++) {
            // for each col
            int[] arr = new int[len];
            for (int j = 0; j < grid.length; j++) {
                
                arr[j] = grid[j][i];

            }

            String hash = sha256Hash(arr);
            if(map.containsKey(hash)){
                counter += map.get(hash);
            }

        }

        return counter;

    }

    public String sha256Hash(int[] array) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] bytes = Arrays.toString(array).getBytes(StandardCharsets.UTF_8);
            byte[] hashBytes = digest.digest(bytes);

            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 not available", e);
        }
    } 
}
