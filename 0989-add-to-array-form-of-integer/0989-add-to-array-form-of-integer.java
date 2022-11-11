class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        
        int curr = k, i = num.length;
        
        List<Integer> al = new ArrayList<>(); 
        
        while(--i >= 0 || curr > 0){
            if(i >= 0){
                curr += num[i];
            }
            al.add(curr % 10);
            curr = curr / 10;
        }
        
        Collections.reverse(al);
        return al;
    }
}