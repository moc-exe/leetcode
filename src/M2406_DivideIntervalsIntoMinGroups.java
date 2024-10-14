/*
*********************************** DESCRIPTION ********************************
*****     2406. Divide Intervals Into Minimum Number of Groups ---  Medium   ******************
https://leetcode.com/problems/divide-intervals-into-minimum-number-of-groups/description/?envType=daily-question&envId=2024-10-13

You are given a 2D integer array intervals where intervals[i] = [lefti, righti] represents the inclusive interval [lefti, righti].

You have to divide the intervals into one or more groups such that each interval is in exactly one group, and no two intervals that are in the same group intersect each other.

Return the minimum number of groups you need to make.

Two intervals intersect if there is at least one common number between them. For example, the intervals [1, 5] and [5, 8] intersect.

 

Example 1:

Input: intervals = [[5,10],[6,8],[1,5],[2,3],[1,10]]
Output: 3
Explanation: We can divide the intervals into the following groups:
- Group 1: [1, 5], [6, 8].
- Group 2: [2, 3], [5, 10].
- Group 3: [1, 10].
It can be proven that it is not possible to divide the intervals into fewer than 3 groups.
Example 2:

Input: intervals = [[1,3],[5,6],[8,10],[11,13]]
Output: 1
Explanation: None of the intervals overlap, so we can put all of them in one group.
 

Constraints:

1 <= intervals.length <= 105
intervals[i].length == 2
1 <= lefti <= righti <= 106


 */
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