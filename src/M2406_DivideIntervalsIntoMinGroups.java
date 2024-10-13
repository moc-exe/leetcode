import java.util.Comparator;
import java.util.PriorityQueue;

public class M2406_DivideIntervalsIntoMinGroups{

    private class Element{

        private int one;
        private int two;
        private Element(int one, int two){this.one = one; this.two = two;}
    }

    public int minGroups(int[][] intervals) {
     


        PriorityQueue<Element> pq = new PriorityQueue<>(new Comparator<Element>() {
            @Override
            public int compare(Element e1, Element e2) {
                if (e1.one != e2.one) {
                    return Integer.compare(e1.one, e2.one);
                }
                return Integer.compare(e1.two, e2.two);
            }
        });

        for (int i = 0; i < intervals.length; i++) {
            var nums = intervals[i];
            pq.add(new Element(nums[0], 1));
            pq.add(new Element(nums[1] + 1, -1));
        }

        int currMax = 0;
        int currSum = 0;

        while(!pq.isEmpty()){

            var elem = pq.remove();
            currSum += elem.two;
            currMax = Math.max(currSum, currMax);
        }
            
        return currMax;

    }
}