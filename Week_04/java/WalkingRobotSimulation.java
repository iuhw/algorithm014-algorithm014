import java.util.HashSet;
import java.util.Set;
// https://leetcode-cn.com/problems/walking-robot-simulation/
class WalkingRobotSimulation {
    public int robotSim(int[] commands, int[][] obstacles) {
        // 位置 有 N E S W
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // 处理障碍物 用的是一个Set
        Set<String> obstaclesSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstaclesSet.add(obstacle[0] + " " + obstacle[1]);
        }

        int x = 0, y = 0, direction = 0, maxDistSquare = 0;
        // 遍历命令
        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -2) {
                // 左转90度
                direction = (direction + 3) % 4;
            } else if (commands[i] == -1) {
                // 右转90度
                direction = (direction + 1) % 4;
            } else {
                // 当前方向直行
                int step = 0;
                while (step < commands[i]
                        && !obstaclesSet.contains(
                        (x + directions[direction][0]) + " " + (y + directions[direction][1])
                )) {
                    x += directions[direction][0];
                    y += directions[direction][1];
                    step++;
                }
            }
            maxDistSquare = Math.max(maxDistSquare, x * x + y * y);
        }

        return maxDistSquare;
    }

    public static void main(String[] args) {
        WalkingRobotSimulation walkingRobotSimulation = new WalkingRobotSimulation();
        int[] commands = new int[]{4, -1, 4, -2, 4};
        int[][] obstacles = new int[][]{{2, 4}};
        int res = walkingRobotSimulation.robotSim(commands, obstacles);
        System.out.println(res);
    }
}