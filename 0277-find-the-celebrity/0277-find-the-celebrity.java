/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    
    int numOfPeople;
    
    public int findCelebrity(int n) {
        numOfPeople = n;
        for(int i = 0; i < n; i++){
            if(isCelebrity(i)){
                return i;
            }
        }
        return -1;
    }
    private boolean isCelebrity(int i){
        for(int j = 0; j < numOfPeople; j++){
            if(i == j) continue;
            if(knows(i, j) || !knows(j, i)){
                return false;
            }
        }
        return true;
    }
}