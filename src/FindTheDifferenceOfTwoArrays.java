import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindTheDifferenceOfTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = new HashSet<>();
        Set<Integer> nums2Set = new HashSet<>();

        for (int num : nums1) {
            nums1Set.add(num);
        }

        for (int num : nums2) {
            nums2Set.add(num);
        }

        Set<Integer> nums1SetOnly = new HashSet<>(nums1Set);
        nums1SetOnly.removeAll(nums2Set);

        Set<Integer> nums2SetOnly = new HashSet<>(nums2Set);
        nums2SetOnly.removeAll(nums1Set);

        return Arrays.asList(nums1SetOnly.stream().toList(), nums2SetOnly.stream().toList());
    }
}
