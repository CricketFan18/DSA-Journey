import java.util.ArrayList;
import java.util.Collections;

public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        // Arrays.sort(trips,(a,b)-> {
        // if(a[1] == b[1])
        // return Integer.compare(a[2],b[2]);
        // return Integer.compare(a[1],b[1]);
        // });
        ArrayList<int[]> timeline = new ArrayList<>();
        for (int[] trip : trips) {
            timeline.add(new int[] { trip[1], trip[0] });
            timeline.add(new int[] { trip[2], -trip[0] });
        }
        Collections.sort(timeline, (a, b) -> {
            if (a[0] == b[0])
                return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });
        int currPassenger = 0;
        for (int[] event : timeline) {
            currPassenger += event[1];
            if (currPassenger > capacity)
                return false;
        }
        return true;
    }
}
