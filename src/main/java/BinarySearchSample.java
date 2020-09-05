import java.util.Arrays;

/**
 * created by victory_woo on 2020/09/04
 */
public class BinarySearchSample {
    public static void main(String[] args) {
        int[] arr = {2, 13, 6, 5, 12, 15, 23, 17, 19, 10};
        System.out.println(search(arr, 17));
    }

    public static int search(int[] arr, int target) {
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;
        int mid;

        while (left < right) {
            mid = (left + right) / 2;

            if (arr[mid] == target) {
                System.out.println(arr[mid]);
                return arr[mid];
            }

            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }

        return -1;
    }
}
