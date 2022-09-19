class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        
        for(String p : paths){
            String[] spath = p.split(" ");
            String r = spath[0];
            for(int i = 1; i < spath.length; i++){
                String[] name_cnt = spath[i].split("\\(");
                name_cnt[1] = name_cnt[1].replace(")", "");
                List<String> al = map.getOrDefault(name_cnt[1], new ArrayList<>());
                al.add(r+"/"+name_cnt[0]);
                map.put(name_cnt[1], al);
            }
        }
        for(String key : map.keySet()){
            if(map.get(key).size() > 1){
                ans.add(map.get(key));
            }
        }
        return ans;
    }
}

/*Input: paths = ["root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"]
Output: [["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]*/