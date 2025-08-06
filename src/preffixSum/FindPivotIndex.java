package preffixSum;

public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int[] prefixSum = new int[nums.length];

        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        if (prefixSum[nums.length - 1] - prefixSum[0] == 0) {
            return 0;
        }

        for (int i = 1; i < nums.length - 1; i++) {
            int leftSum = prefixSum[i - 1];
            int rightSum = prefixSum[nums.length - 1] - prefixSum[i + 1] + nums[i + 1];

            if (leftSum == rightSum) {
                return i;
            }
        }

        if (prefixSum[nums.length - 2] == 0) {
            return nums.length - 1;
        }

        return -1;
    }

    public int pivotIndex2(int[] nums) {
        int sum = 0;
        int leftSum = 0;
        for (int num : nums) {
            sum += num;
        }
        for (int i = 0; i < nums.length; i++) {
            int rightSum = sum - leftSum - nums[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
