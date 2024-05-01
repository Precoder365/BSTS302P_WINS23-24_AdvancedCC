// LIS+LDS-1(peak)

public class Main {
    public static int longestBitonicSubsequence(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;

        // Length of increasing subsequence ending at index i
        int[] lis = new int[n];
        // Length of decreasing subsequence starting at index i
        int[] lds = new int[n];

        // Calculate LIS (Longest Increasing Subsequence) from left to right
        for (int i = 0; i < n; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        // Calculate LDS (Longest Decreasing Subsequence) from right to left
        for (int i = n - 1; i >= 0; i--) {
            lds[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }

        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            maxLength = Math.max(maxLength, lis[i] + lds[i] - 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {1, 11, 2, 10, 4, 5, 2, 1};
        System.out.println("Length of longest bitonic subsequence: " + longestBitonicSubsequence(nums));
    }
}
