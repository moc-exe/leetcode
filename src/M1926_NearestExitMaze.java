/*
 * https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/?envType=study-plan-v2&envId=leetcode-75
 * MEDIUM 1926. Nearest Exit from Entrance in Maze
 * 
 */

import java.util.LinkedList;
import java.util.Queue;

public class M1926_NearestExitMaze {

    // private class Pair<U, V> {
    //     private final U first;
    //     private final V second;

    //     private Pair(U first, V second) {
    //         this.first = first;
    //         this.second = second;
    //     }
    // }

    private static boolean found = false;
    private static int stepCount = -1;

    public static int nearestExit(char[][] maze, int[] entrance) {
        
        found = false;
        stepCount = -1;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[100][100];
        int YBound = maze.length;
        int XBound = maze[0].length;

        int entranceY = entrance[0];
        int entranceX = entrance[1];
        visited[entranceY][entranceX] = true;

        if(entranceY - 1 >= 0 && maze[entranceY-1][entranceX] == '.'){
            queue.add(new int[]{entranceY-1, entranceX, 1});
            visited[entranceY-1][entranceX] = true;
        }
        if(entranceY + 1 < YBound && maze[entranceY+1][entranceX] == '.'){
            queue.add(new int[]{entranceY+1, entranceX, 1});
            visited[entranceY+1][entranceX] = true;
        }
        if(entranceX - 1 >= 0 && maze[entranceY][entranceX-1] == '.'){
            queue.add(new int[]{entranceY, entranceX-1, 1});
            visited[entranceY][entranceX-1] = true;
        }
        if(entranceX + 1 < XBound && maze[entranceY][entranceX+1] == '.'){
            queue.add(new int[]{entranceY, entranceX+1, 1});
            visited[entranceY][entranceX+1] = true;
        }

        while (!queue.isEmpty() && !found) {
            
            checkNeighbors(visited, queue, XBound, YBound, entranceX, entranceY, maze);

        }
        return stepCount;
    }

    public static void checkNeighbors(boolean[][] visited, Queue<int[]> q, int XBound, int YBound, int entranceX, int entranceY, char[][] maze){

        int[] currCoords = q.poll();
        int currY = currCoords[0];
        int currX = currCoords[1];
        int currStepCount = currCoords[2];

        if(currY == 0 || currX == 0 || currY == YBound - 1 || currX == XBound - 1){
            if(currY != entranceY || currX != entranceX){
                found = true;
                stepCount = currStepCount;
                return;
            }
        }
        if(currY - 1 >= 0 && maze[currY-1][currX] == '.' && !visited[currY-1][currX]){
            
            q.add(new int[]{currY-1, currX, currStepCount+1});
            visited[currY-1][currX] = true;
        }
        if(currY + 1 < YBound && maze[currY+1][currX] == '.' && !visited[currY+1][currX]){
            q.add(new int[]{currY+1, currX, currStepCount+1});
            visited[currY+1][currX] = true;
        }
        if(currX - 1 >= 0 && maze[currY][currX-1] == '.' && !visited[currY][currX-1]){
            q.add(new int[]{currY, currX-1, currStepCount+1});
            visited[currY][currX-1] = true;
        }
        if(currX + 1 < XBound && maze[currY][currX+1] == '.' && !visited[currY][currX+1]){
            q.add(new int[]{currY, currX+1, currStepCount+1});
            visited[currY][currX+1] = true;
        }

    }
    public static void main(String[] args) {
        
        char[][] maze = {
            {'+', '.', '+', '+', '+', '+', '+'},
            {'+', '.', '+', '.', '.', '.', '+'},
            {'+', '.', '+', '.', '+', '.', '+'},
            {'+', '.', '.', '.', '+', '.', '+'},
            {'+', '+', '+', '+', '+', '.', '+'}
        };
        System.out.println(nearestExit(maze, new int[]{0,1}));


        

    }

    /*
     * 
     * 
     * 
     * [
     *  ["+",".","+","+","+","+","+"],
     *  ["+",".","+",".",".",".","+"],
     *  ["+",".","+",".","+",".","+"],
     *  ["+",".",".",".","+",".","+"],
     *  ["+","+","+","+","+",".","+"]
     * ]
     * 
     */
}
