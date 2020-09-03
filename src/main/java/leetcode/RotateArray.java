package leetcode;

/**
 * created by victory_woo on 2020/09/03
 */
public class RotateArray {
    public static void main(String[] args) {
        //rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        rotate(new int[]{-1, -100, 3, 99}, 2);
    }

    public static void rotate(int[] nums, int k) {
        int count = 0;
        int start = 0;
        while (count < nums.length) {
            int current = start;
            int cache = nums[current];

            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = cache;
                cache = temp;
                current = next;
                count++;
            } while (start != current);
            start++;
        }
        for (int i : nums) System.out.println(i);
    }
}
