package ArrayAndString;

/**
 * 给出一个长度为 n 的数组 a，你需要在这个数组中找到一个长度至少为 m 的区间，使得这个区间内的数字的和尽可能小。
 */

import java.util.Scanner;

/**
 * 输入：
 * - 第一行包含一个正整数 n，m,表示数组的大小和所选区间的最小长度。
 * - 第二行包含 n 个整数，中间用空格隔开。
 * 输出：
 * - 输出仅包含一个正整数，表示所选区间的和。
 *
 */
public class SimpleGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        int[] nums = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
            if (i < m)  sum += nums[i];
        }
        int pre = sum, min = sum;
        for (int i = m; i < n; i++) {
            sum += nums[i] - nums[i-m];
            pre = Math.min(pre+nums[i], sum);
            min = Math.min(pre, min);
        }
        System.out.println(min);
    }
}
