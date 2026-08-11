public class MinSidewaysJump {

    int solveMem(int idx, int lane, int[] obstacles) {
        if (idx == obstacles.length - 1)
            return 0;

        int ans = 0;
        if (obstacles[idx + 1] != lane)
            ans += solveMem(idx + 1, lane, obstacles);
        else {
            for (int i = 1; i <= 3; i++) {
                if (i == lane)
                    continue;
                if(i != obstacles[idx])
                    ans += 1+solveMem(idx, i, obstacles);
            }
        }
        return ans;
    }

    public int minSideJumps(int[] obstacles) {
        return solveMem(0, 2, obstacles);
    }
}
