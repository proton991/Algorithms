package Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Auther: 99615
 * @Date: 2021/1/29 10:59
 * @Description:
 */
public class Permutations {
    List<List<Integer>> res = new ArrayList<>();
    int n;
    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        List<Integer> out = new ArrayList<>();
        for (int i = 0; i < n; i++)
            out.add(nums[i]);
        backtrack(0, out, nums);
        return res;
    }

    public void backtrack(int start, List<Integer> out, int[] nums) {
        if (start == n)
            res.add(new ArrayList<>(out));
        for (int i = start; i < n; i++) {
            Collections.swap(out, start, i);
            backtrack(start+1, out, nums);
            Collections.swap(out, start, i);
        }
    }
}
