package Sort;

import java.util.Arrays;

import static Sort.SortUtils.printArr;

/**
 * @Auther: 99615
 * @Date: 2021/1/30 09:31
 * @Description:
 */
public class MergeSort {

    /**
     * 归并排序
     *
     * @param array
     * @return
     */
    public static int[] sort(int[] array) {
        if (array.length < 2) return array;
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(sort(left), sort(right));
    }
    /**
     * 归并排序——将两段排序好的数组结合成一个排序数组
     *
     * @param left
     * @param right
     * @return
     */
    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length)
                result[index] = right[j++];
            else if (j >= right.length)
                result[index] = left[i++];
            else if (left[i] > right[j])
                result[index] = right[j++];
            else
                result[index] = left[i++];
        }
        return result;
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] nums = {4, 23, 6, 78, 1, 54, 231, 9, 12};
        printArr(mergeSort.sort(nums));
    }
}
