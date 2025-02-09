import java.util.HashMap;
import java.util.Map;

public class CountNumberOfPairsWithAbsoluteDifference {
    public int countKDifference(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            if (frequencyMap.containsKey(num - k)) {
                count += frequencyMap.get(num - k);
            }
            if (frequencyMap.containsKey(num + k)) {
                count += frequencyMap.get(num + k);
            }

            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        return count;
    }
}
