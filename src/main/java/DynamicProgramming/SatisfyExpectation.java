package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个非负整数序列x1, x2, …, xn，可以给每一个整数取负数或者取原值，求有多少种取法使得这些整数的和等于期望值E。
 *
 * 例子：
 * 输入：非负整数序列为1, 1, 1, 1, 1，期望值E为3
 * 输出 ：5
 * 5种取法分别为：
 * -1+1+1+1+1 = 3
 * 1-1+1+1+1 = 3
 * 1+1-1+1+1 = 3
 * 1+1+1-1+1 = 3
 * 1+1+1+1-1 = 3
 */
public class SatisfyExpectation {
    int count = 0;
    int n;
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public int Solution(int[] nums, int E) {
        int sum = Arrays.stream(nums).sum();
        n = nums.length;
        int target = (sum - E) / 2;
        dfs(nums, 0, target);
        return ans.size();
    }

    public void dfs(int[] nums, int start, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < n; i++) {
            temp.add(nums[i]);
            dfs(nums, i+1, target-nums[i]);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
//        int[] nums = {10,5,5,3,7};
        int[] nums1 = {1,1,1,1,1};
        SatisfyExpectation satisfyExpectation = new SatisfyExpectation();
        System.out.println(satisfyExpectation.Solution(nums1, 10));
    }
}
