package Searching;

public class SearchRotated {

    private int searchRotated(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(arr[mid] == target)
                return mid;
            else if (arr[left] < arr[mid]) { // left is sorted
                if(target < arr[mid] && target >= arr[left]) { // target lies in the sorted part
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // right is sorted
                if(target > arr[mid] && target <= arr[right]) { // target lies in the sorted part
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        SearchRotated sr = new SearchRotated();
        int[] arr = new int[] {3, 4, 5, 1, 2};
        for(int i = 1; i <= 6; i++) {
            int val = sr.searchRotated(arr, i);
            System.out.println(val);
        }
    }
}
