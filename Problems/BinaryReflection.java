import java.util.Arrays;

public class BinaryReflection {
    public int getMirrorNumber(int num) {
        int mirror = 0;
        while (num != 0) {
            int lastBit = (num & 1);
            mirror = (mirror << 1) + lastBit;
            num = num >> 1;
        }
        return mirror;
    }

    public int[] sortByReflection(int[] nums) {
        int n = nums.length;
        int[] mirrorArray = new int[n];
        Integer[] indices = new Integer[n];

        for (int i = 0; i < n; i++) {
            mirrorArray[i] = getMirrorNumber(nums[i]);
            indices[i] = i;
        }
        Arrays.sort(indices, (i, j) -> {
            if(mirrorArray[i] != mirrorArray[j])
                return Integer.compare(mirrorArray[i], mirrorArray[j]);
            else
                return Integer.compare(nums[i], nums[j]);
        });
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = nums[indices[i]];
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryReflection ob = new BinaryReflection();
        System.out.println(ob.getMirrorNumber(Integer.valueOf(args[0])));
    }
}