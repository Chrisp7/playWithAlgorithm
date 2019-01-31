package liked;

import java.util.*;

interface Robot {
    // Returns true if the cell in front is open and robot moves into the cell.
    // Returns false if the cell in front is blocked and robot stays in the current cell.
    public boolean move();

    // Robot will stay in the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    public void turnLeft();

    public void turnRight();

    // Clean the current cell.
    public void clean();
}

public class Lc489 {
    private int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public void cleanRoom(Robot robot) {
        traverse(robot, 0, 0, 0, new HashSet<String>());
    }

    private void traverse(Robot robot, int x, int y, int curDir, HashSet<String> visited) {
        visited.add(x + "," + y); // visited set add current place
        robot.clean(); // do what the problem ask to do

        for (int i = 0; i < 4; i++) {
            int newDir = (curDir + i) % 4;
            int newX = x + dirs[newDir][0];
            int newY = y + dirs[newDir][1];
            // consider if the robot can move to new direction, if it meets obstacle or boundary (these are considered by given code) if it has been visited
            if (!visited.contains(newX + "," + newY) && robot.move()) {
                traverse(robot, newX, newY, newDir, visited);
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            robot.turnRight();
        }

    }
}
