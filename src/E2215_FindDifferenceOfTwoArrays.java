import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class E2215_FindDifferenceOfTwoArrays {
    

    // memory limit exceeded for this solution... somehow

    // public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        

    //         List<List<Integer>> out = new ArrayList<>();
            

    //         var list1 = new ArrayList<Integer>();
    //         var list2 = new ArrayList<Integer>();

    //         Arrays.sort(nums1);
    //         Arrays.sort(nums2);

    //         int i=0,j = 0;
    //         while(i < nums1.length && j < nums2.length){

    //             if(nums1[i] == nums2[j]){
    //                 i++;
    //                 j++;
    //                 continue;
    //             }
    //             else if(nums1[i] < nums2[j]){
    //                 list1.add(nums1[i]);
    //                 i++;
    //             }
    //             else{
    //                 list2.add(nums2[j]);
    //                 j++;
    //             }
    //         }
    //         while(i < nums1.length){

    //             list1.add(nums1[i]);
    //             i++;
    //         }
    //         while(j < nums2.length){

    //             list2.add(nums2[j]);
    //             i++;
    //         }

    //         out.add(list1);
    //         out.add(list2);
    //         return out;

    // }


    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        Set<Integer> nums1Set = new HashSet<>();
        Set<Integer> nums2Set = new HashSet<>();

        for(var num: nums1){
            nums1Set.add(num);
        }
        for (Integer integer : nums2) {
            nums2Set.add(integer);
        }
        
        var list1 = new ArrayList<Integer>();
        var list2 = new ArrayList<Integer>();

        for (var elem : nums1Set) {
            
            if(!nums2Set.contains(elem)){
                list1.add(elem);
            }
        }
        for(var elem : nums2Set){

            if(!nums1Set.contains(elem)){
                list2.add(elem);
            }

        }

        List<List<Integer>> out = new ArrayList<>();
        out.add(list1);
        out.add(list2);
        return out;
    }

}
