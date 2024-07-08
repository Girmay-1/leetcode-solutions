public class RobotPosition {
    public static int[] walk(String path) {
        int x = 0;
        int y = 0;
        for (char coordinate : path.toCharArray()) {
            if (coordinate == 'U')
                y++;
            else if (coordinate == 'D')
                y--;
            else if (coordinate == 'R')
                x++;
            else if (coordinate == 'L')
                x--;
        }

        return new int[]{x, y};
    }
}