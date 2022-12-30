class Solution {
    public String[] getFolderNames(String[] names) {
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < names.length; i++){
            String name = names[i];
            if(map.containsKey(name)){
                int num = map.get(name) + 1;
                String nameWithSuffix = name+"("+num+")";
                while(map.containsKey(nameWithSuffix)){
                    num = num + 1;
                    nameWithSuffix = name+"("+num+")";
                }
                names[i] = nameWithSuffix;
                map.put(nameWithSuffix, 0);
                map.put(name, num);
            }
            else {
                map.put(name, 0);
            }
        }
        return names;
    }
}