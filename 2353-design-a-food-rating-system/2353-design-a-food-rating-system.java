class FoodRatings {
    
    class Pair{
        String name, cuisine;
        int rating;
        
        Pair(String name, int rating, String cuisines){
            this.name = name;
            this.rating = rating;
            this.cuisine = cuisines;
        }
    }
    
    
    Map<String, Pair> foodMap = new HashMap<>();
    Map<String, PriorityQueue<Pair>> rateMap = new HashMap<>();
    
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        
        
        for(int i = 0; i < foods.length; i++){
            Pair p = new Pair(foods[i], ratings[i], cuisines[i]);
            
            rateMap.putIfAbsent(cuisines[i], new PriorityQueue<>((a, b) -> (a.rating == b.rating) ? (a.name).compareTo(b.name) : b.rating - a.rating));
            
            PriorityQueue<Pair> pq = rateMap.get(cuisines[i]);
            // System.out.println()
            pq.add(p);
            foodMap.put(foods[i], p);
        }
    }
    
    
    public void changeRating(String food, int newRating) {
        
        Pair p = foodMap.get(food);
        
        PriorityQueue<Pair> pq = rateMap.get(p.cuisine);
        pq.remove(p);
        p.rating = newRating;
        pq.add(p);
        
    }
    
    public String highestRated(String cuisine) {
        
        return rateMap.get(cuisine).peek().name;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */