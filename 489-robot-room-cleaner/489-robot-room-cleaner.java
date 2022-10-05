/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
    
    int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    Robot robot;
    Set<String> visited = new HashSet<>();
    
    public void cleanRoom(Robot robot) {
        this.robot = robot;
        backtrack(0, 0, 0);
    }
    
    private void goBack(){
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
    
    private void backtrack(int currRow, int currCol, int d){
        visited.add(currRow+" "+ currCol);
        robot.clean();
        
        for(int i =0 ;i < 4; i++){
            int newD = (d + i) % 4;
            
            int newRow = currRow + dir[newD][0];
            int newCol = currCol + dir[newD][1];
            
            if(!visited.contains(newRow+" "+newCol) && robot.move()){
                backtrack(newRow, newCol, newD);
                goBack();
            }
            
            robot.turnRight();
        }
    }
}