class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;
        
        LinkedList<String> q = new LinkedList<>();
        q.add(beginWord);
        
        Set<String> vis = new HashSet<>();
        //vis.add(beginWord);
        
        int ans = 1;
        
        while(!q.isEmpty()){
            int sz = q.size();
            while(sz-- > 0){
                
                String word = q.poll();
                
                if(word.equals(endWord)) return ans;
                
                for(int i = 0; i < word.length(); i++){
                    char[] arr = word.toCharArray();
                    for(int c = 'a'; c <= 'z'; c++){
                        
                        char old = arr[i];
                        arr[i] = (char) c;
                        
                        String str = new String(arr);
                        if(set.contains(str) && !vis.contains(str)){
                            q.add(str);
                            vis.add(str);
                        }
                        arr[i] = old;
                    }
                }
                
            }
            ans++;
        }
        return 0;
    }
}