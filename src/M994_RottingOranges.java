/*
 * https://leetcode.com/problems/rotting-oranges/?envType=study-plan-v2&envId=leetcode-75
 * MEDIUM - 994. Rotting Oranges
 */

import java.util.LinkedList;
import java.util.Queue;

public class M994_RottingOranges {

    static int minsTotal = 0;
    static int freshCount = 0;
    static int rottingActionCount = 0;

    public static int orangesRotting(int[][] grid) {

        minsTotal = 0;
        freshCount = 0;
        rottingActionCount = 0;

        boolean[][] visited = new boolean[100][100];
        Queue<int[]> q = new LinkedList<>();
        // assuming rectangular and not ragged 2d matrix
        int XBound = grid.length;
        int YBound = grid[0].length;

        firstScan(q, visited, grid, XBound, YBound);
        while(!q.isEmpty()){
            traverse(q, visited, grid, XBound, YBound);
        }
        if(rottingActionCount == freshCount){ // all of em are rotten now
            return minsTotal;
        }
        else{
            return -1;
        }

    }

    public static void firstScan(Queue<int[]> q, boolean[][] visited, int[][] oranges, int Xbound, int YBound){

        for (int i = 0; i < Xbound; i++) {
            for (int j = 0; j < YBound; j++) {
                
                int currOrange = oranges[i][j];
                // rotten
                if(currOrange == 2){
                    q.add(new int[]{i,j,0}); // add the first
                    visited[i][j] = true; // visited alr now, we have to mark it at this step,
                    // else crazy complexity
                }
                else if(currOrange == 1){

                    freshCount++;
                }
            }
        }
    }

    public static void traverse(Queue<int[]> q, boolean[][] visited, int[][] oranges, int Xbound, int YBound){

        int[] currOrange = q.poll();
        int currX = currOrange[0];
        int currY = currOrange[1];
        int currMin = currOrange[2];
        if(oranges[currX][currY] != 2){rottingActionCount++;}
        oranges[currX][currY] = 2; // rotten now !
        minsTotal = Math.max(minsTotal, currMin);

        if(currX - 1 >= 0 && !visited[currX-1][currY] && oranges[currX-1][currY] == 1){
            q.add(new int[]{currX-1, currY, minsTotal+1});
            visited[currX-1][currY] = true;
        }
        if(currX + 1 < Xbound && !visited[currX+1][currY] && oranges[currX+1][currY] == 1){
            q.add(new int[]{currX+1, currY, minsTotal+1});
            visited[currX+1][currY] = true;
        }
        if(currY - 1 >= 0 && !visited[currX][currY-1] && oranges[currX][currY-1] == 1){
            q.add(new int[]{currX, currY-1, minsTotal+1});
            visited[currX][currY-1] = true;
        }
        if(currY + 1 < YBound && !visited[currX][currY+1] && oranges[currX][currY+1] == 1){
            q.add(new int[]{currX, currY+1, minsTotal+1});
            visited[currX][currY+1] = true;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        System.out.println(orangesRotting(grid));
        
    }

}
