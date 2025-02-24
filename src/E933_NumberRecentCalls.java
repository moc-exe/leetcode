/*
 * EASY - 933. Number of Recent Calls
 * https://leetcode.com/problems/number-of-recent-calls/description/?envType=study-plan-v2&envId=leetcode-75
 * 
 */



import java.util.ArrayList;
import java.util.Collections;

public class E933_NumberRecentCalls {

    class RecentCounter {

        private ArrayList<Integer> requests;

        public RecentCounter() {

            requests = new ArrayList<>();
            
        }
        
        public int ping(int t) {

            int counter = 0;
            requests.add(t);
            Collections.sort(requests);
            int pos = Collections.binarySearch(requests, t);
            while(pos>=0 && requests.size() > 0 && requests.get(pos) >= t - 3000){
                counter++;
                pos--;
            }

            return counter;  
        }
    }

}
