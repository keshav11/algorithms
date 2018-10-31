package DynamicProgramming;

public class MaxSumSubarray {
    int maxSubarray(int arr[]) {

        int maxSum = arr[0];
        int currSum = arr[0];
        int maxLeft = 0;
        int maxRight = 0;
        int currLeft = 0;

        for (int i = 1; i < arr.length; i++) {
            if(currSum < 0) {
                currSum = 0;
                currLeft = i;
            }
            currSum += arr[i];
            if(currSum > maxSum) {
                maxSum = currSum;
                maxLeft = currLeft;
                maxRight = i;
            }
        }

        System.out.println(maxLeft + " " + maxRight + " " + maxSum);

        return maxSum;

    }

    public static void main(String[] args) {
        new MaxSumSubarray().maxSubarray(new int[] {-1, 1, 3, 4, -5, 1, 2, -9});
    }
}
