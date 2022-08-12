/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    int num;
    public int findCelebrity(int n) {
        
        num = n;
        int celebrity = 0;
        
        for(int i = 0; i < n; i++){
            if(knows(celebrity, i)){
                celebrity = i;
            }
        }
        
        if(isCelebrity(celebrity)){
            return celebrity;
        }
        return -1;
    }
    
    private boolean isCelebrity(int celebrity){
        
        for(int i = 0; i < num; i++){
            if(celebrity == i) continue;
            if(knows(celebrity, i) || !knows(i, celebrity)) return false;
        }
        return true;
    }
}