class Solution {
    public List<Integer> diffWaysToCompute(String  expression) {
        
        List<Integer> res = new ArrayList<>();
        Map<String, List<Integer>> map = new HashMap<>();
        
        if(map.containsKey(expression)) return map.get(expression);
        
        for(int i = 0; i < expression.length(); i++){
            
            char ch = expression.charAt(i);
            if(ch == '+' || ch == '-' || ch == '*'){
                
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i+1));
                
                for(int a : left){
                    for(int b : right){
                        if(ch == '+'){
                            res.add(a + b);
                        }
                        else if(ch == '-'){
                            res.add(a - b);
                        }
                        else if(ch == '*'){
                            res.add(a * b);
                        }
                    }
                }
            }
        }
        
        if(res.size() == 0) res.add(Integer.parseInt(expression));
        
        map.put(expression, res);
        return res;
    }
}