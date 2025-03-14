public class MaximumAverageSubarray1 {
    public double findMaxAverage2(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double result = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            result = Math.max(result, sum);
        }

        return result / k;
    }

    public double findMaxAverage1(int[] nums, int k) {
        int[] sums = new int[nums.length];
        sums[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }

        double maxAv = sums[k - 1] * 1.0 / k;
        for (int i = k; i < nums.length; i++) {
            maxAv = Math.max(maxAv, (sums[i] - sums[i - k]) * 1.0 / k);
        }

        return maxAv;
    }
}
