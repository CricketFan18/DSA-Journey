import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllNum {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int prev = lower;
        for (int num : nums) {
            if (num < prev)
                continue;

            if (num > upper)
                break;

            if (prev < num) {
                res.add(Arrays.asList(prev, num - 1));
            }

            prev = num + 1;
        }
        if (prev <= upper)
            res.add(Arrays.asList(prev, upper));

        return res;
    }
}
