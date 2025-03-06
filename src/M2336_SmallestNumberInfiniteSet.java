/*
 * MEDIUM 2336. Smallest Number in Infinite Set
 * https://leetcode.com/problems/smallest-number-in-infinite-set/description/?envType=study-plan-v2&envId=leetcode-75
 * 
 */
import java.util.PriorityQueue;

public class M2336_SmallestNumberInfiniteSet {
    
    private class CustomPriorityQueue<E> extends PriorityQueue<E>{
        @Override
        public boolean add(E elem){
            return this.contains(elem) ?  false : super.add(elem);
        }
    } 

    class SmallestInfiniteSet {

        private CustomPriorityQueue<Integer> q;

        public SmallestInfiniteSet() {

            q = new CustomPriorityQueue<>();
            for (int i = 1; i <= 1000 ; i++) {
                q.add(i);
            }
            
        }
        
        public int popSmallest(){
            if(!q.isEmpty()){
                return q.poll();
            }
            return -1;
        }
        
        public void addBack(int num) {
            q.add(num);            
        }
    }
}
