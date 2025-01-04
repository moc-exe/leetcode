import java.util.ArrayList;
import java.util.List;
public class E1431_KidsWithGreatestNumberOfCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
       
        int max_candies = 0;

        for (int i = 0; i < candies.length; i++) {
            max_candies = Math.max(max_candies, candies[i]);
        }

        var out = new ArrayList<Boolean>();

        for (int i = 0; i < candies.length; i++){
            if((candies[i] + extraCandies) >= max_candies){
                out.add(true);
            }
            else{out.add(false);}
        }

        return out;
    }
}
