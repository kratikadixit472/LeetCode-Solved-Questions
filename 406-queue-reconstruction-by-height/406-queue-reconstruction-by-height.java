class Solution {
    public int[][] reconstructQueue(int[][] people) {
        
        Arrays.sort(people, (a, b) -> 
            (a[0] == b[0]) ? a[1] - b[1] : b[0] - a[0]
        );
        
//         for(int[] ppl : people){
//             System.out.print("[" + ppl[0] + "," + ppl[1] + "], ");
//         }
        
        List<int[]> res = new ArrayList<>();
        
        for(int i = 0; i < people.length; i++){
            res.add(people[i][1], people[i]);
        }
        
        return res.toArray(new int[res.size()][2]);
    }
}
