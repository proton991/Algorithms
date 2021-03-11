package Sort;

import java.util.Arrays;

/**
 * @Auther: 99615
 * @Date: 2020/9/11 15:22
 * @Description:
 */
class SortUtils {
    static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    static void printArr(int[] toPrint) {
        System.out.println(Arrays.toString(toPrint));
    }

}
