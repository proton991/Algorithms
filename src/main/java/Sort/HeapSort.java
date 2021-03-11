package Sort;

import static Sort.SortUtils.printArr;
import static Sort.SortUtils.swap;

/**
 * @Auther: 99615
 * @Date: 2021/1/29 12:02
 * @Description:
 */
public class HeapSort {

    public void sort(int[] nums) {
        int n = nums.length;
        for (int i = n/2-1; i >=0; --i) {
            heapify(nums, n, i);
        }
        for (int i = n-1; i >=0; --i) {
            swap(nums, i, 0);
            heapify(nums, i, 0);
        }
    }
    public void heapify(int[] nums, int n, int i) {
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int max = i;
        if (leftChild < n && nums[leftChild] > nums[max])
            max = leftChild;
        if (rightChild < n && nums[rightChild] > nums[max])
            max = rightChild;
        if (max != i) {
            swap(nums, max, i);
            heapify(nums, n, max);
        }
    }



    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] nums = {4, 23, 6, 78, 1, 54, 231, 9, 12};
        heapSort.sort(nums);
        printArr(nums);
    }
}
