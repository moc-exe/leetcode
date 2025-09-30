import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
class FoodRatings {

    private HashMap<String, Integer> dishToRatingMapping;
    private HashMap<String, PriorityQueue<String>> cuisineToSortedDishesMapping;
    private HashMap<String, String> dishToCuisineMapping;
    private Comparator<String> dishComparator = (String dish1, String dish2) -> {
        
        int dish1Rating = dishToRatingMapping.get(dish1);
        int dish2Rating = dishToRatingMapping.get(dish2);
        if(dish1Rating == dish2Rating){
            return dish1.compareTo(dish2);
        }
        else{
            return Integer.compare(dish2Rating, dish1Rating);
        }
    };

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        
        this.dishToRatingMapping = new HashMap<>();
        this.cuisineToSortedDishesMapping = new HashMap<>();
        this.dishToCuisineMapping = new HashMap<>();

        for(int i = 0; i < foods.length; i ++){
            String dish = foods[i];
            String cuisine = cuisines[i];
            int defaultRating = ratings[i];

            this.dishToRatingMapping.put(dish, defaultRating);
            this.dishToCuisineMapping.put(dish, cuisine);
            
            if(!cuisineToSortedDishesMapping.containsKey(cuisine)){
                this.cuisineToSortedDishesMapping.put(cuisine, new PriorityQueue<>(dishComparator));
            }
            PriorityQueue<String> dishes = this.cuisineToSortedDishesMapping.get(cuisine);
            dishes.add(dish);
        }
    }
    
    public void changeRating(String food, int newRating) {
        this.dishToRatingMapping.put(food, newRating); // update rating
        
        String cuisine = this.dishToCuisineMapping.get(food);
        this.cuisineToSortedDishesMapping.get(cuisine).remove(food);
        this.cuisineToSortedDishesMapping.get(cuisine).add(food);
    }
    
    public String highestRated(String cuisine) {
        return cuisineToSortedDishesMapping.get(cuisine).peek();
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */