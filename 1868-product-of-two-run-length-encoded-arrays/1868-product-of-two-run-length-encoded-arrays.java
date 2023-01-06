class Solution {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        
        List<List<Integer>> ans = new ArrayList<>();
        List<int[]> al = new ArrayList<>();
        int i = 0, j = 0;
        int n = encoded1.length, m = encoded2.length;
        
        while(i < n && j < m){
            int num1 = encoded1[i][0];
            int num2 = encoded2[j][0];
            int f1 = encoded1[i][1], f2 = encoded2[j][1];
            
            if(f1 == f2){
                al.add(new int[]{num1 * num2, f1});
                i++; j++;
            }
            else if(f1 < f2){
                int diff = f2 - f1;
                al.add(new int[]{num1 * num2, f1});
                encoded2[j][1] = diff;
                i++;
            }
            else if(f1 > f2){
                int diff = f1 - f2;
                al.add(new int[]{num1 * num2, f2});
                encoded1[i][1] = diff;
                j++;
            }
        }
        
        int[] prev = al.get(0);

        for(int ii = 1; ii < al.size(); ii++){
            if(prev[0] == al.get(ii)[0]){
                prev[1] += al.get(ii)[1];
            }
            else{
                // System.out.println(al.get(i-1)+" "+al.get(i)+" "+ cnt+", ");
                List<Integer> all = new ArrayList<>();
                all.add(prev[0]); all.add(prev[1]);
                ans.add(all);
                prev = al.get(ii);
            }
        }
        List<Integer> all = new ArrayList<>();
        all.add(prev[0]); all.add(prev[1]);
        ans.add(all);
        
        return ans;
    }
}