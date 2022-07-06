class Solution {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        
        int least = Integer.MAX_VALUE, sleast = Integer.MAX_VALUE;
        
        for(int j = 0; j < costs[0].length; j++){
            if(least > costs[0][j]){
                sleast = least;
                least = costs[0][j];
            }
            else if(sleast > costs[0][j]){
                sleast = costs[0][j];
            }
        }
        
        for(int i = 1; i < n; i++){
            int nleast = Integer.MAX_VALUE, nsleast = Integer.MAX_VALUE;
        
            for(int j = 0; j < costs[0].length; j++){
                
                if(least != costs[i-1][j]){
                    // System.out.println("Yes");
                    costs[i][j] = costs[i][j] + least;
                    // System.out.println(costs[i][j] +" ");
                }
                else{
                    costs[i][j] = sleast + costs[i][j];
                }
                // System.out.print(i + " " +j +" "+ least + " "+ sleast +" " + costs[i][j] +" ");
                if(nleast >= costs[i][j]){
                    // System.out.print("Yes in least ");
                    nsleast = nleast;
                    nleast = costs[i][j];
                    
                }
                else if(nsleast >= costs[i][j]){
                    nsleast = costs[i][j];
                }
                // System.out.println( " -> " + nleast +" "+ nsleast +" ");
            }
            least = nleast;
            sleast = nsleast;
        }
        
        return least;
    }
}