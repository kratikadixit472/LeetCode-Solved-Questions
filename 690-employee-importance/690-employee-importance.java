/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> subMap = new HashMap<>();
        
        for(Employee e : employees){
            subMap.put(e.id, e);
        }
        
        
        return DFS(id, subMap);
    }
    
    private int DFS(int id, HashMap<Integer, Employee> subMap){
        
        Employee e = subMap.get(id);
        int totalImportance = e.importance;
        for(Integer nid : e.subordinates){
            totalImportance += DFS(nid, subMap);
        }
        return totalImportance;
    }
}