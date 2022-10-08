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
    Robot robot;
    Set<String> set = new HashSet<>();
    int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public void cleanRoom(Robot robot) {
        this.robot = robot;
        backtrack(0, 0, 0);
    }
    private void backtrack(int cr, int cc, int d){
        robot.clean();
        set.add(cr+" "+cc);
        
        for(int i = 0; i < 4; i++){
            int newd = (i + d) % 4;
            int nr = cr + dir[newd][0];
            int nc = cc + dir[newd][1];
            
            if(!set.contains(nr+" "+nc) && robot.move()){
                backtrack(nr, nc, newd);
                gotBack();
            }
            robot.turnRight();
        }
    }
    private void gotBack(){
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}