package cn.nice2cu;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author: zhaoshiqiu
 * @create: 2020-11-04 16:04
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = {20, 36, 2, 69, 87, 3, 15, 14, 22};

        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(quickSort(array)));
    }

    /**
    * 快速排序
    * @param sourceArray 原数组
    * @return int[]
    */
    public static int[] quickSort(int[] sourceArray) {
        // 对array进行拷贝, 不改变参数内容;
        int[] arr  = Arrays.copyOf(sourceArray, sourceArray.length);

        return sort(arr, 0, arr.length - 1);
    }

    private static int[] sort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            sort(arr, left, partitionIndex - 1);
            sort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    private static int partition(int[] arr, int left, int right) {
        // 设定基准值（pivot）
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
