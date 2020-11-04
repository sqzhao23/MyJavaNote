package cn.nice2cu;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author: zhaoshiqiu
 * @create: 2020-11-03 15:31
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] array = {20, 36, 2, 69, 87, 3, 15, 14, 22};

        System.out.println(Arrays.toString(array));

        // 递归实现
        //System.out.println(Arrays.toString(sort1(array)));
        // 迭代实现
        System.out.println(Arrays.toString(sort2(array)));
    }

    /**
    * 归并排序(递归版)
    * @param sourceArray 原数组
    * @return int[]
    */
    public static int[] sort1(int[] sourceArray) {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        if (arr.length < 2) {
            return arr;
        }
        int middle = (int) Math.floor(arr.length / 2);

        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);

        return mergeSort(sort1(left), sort1(right));
    }

    private static int[] mergeSort(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0;
        while (left.length > 0 && right.length > 0) {
            if (left[0] <= right[0]) {
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }

        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }

        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }

        return result;
    }

    /**
    * 递归排序(迭代版)
    * @param sourceArray 原数组
    * @return void
    */
    public static int[] sort2(int[] sourceArray) {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        int len = arr.length;
        int k = 1;

        while(k < len) {
            MergePass(arr, k, len);
            k *= 2;
        }
        return arr;
    }

    private static void MergePass(int[] arr, int k, int n) {
        int i = 0;
        int j;

        // 从前往后,将2个长度为k的子序列合并为1个
        while (i < n - 2 * k + 1) {
            merge(arr, i, i + k-1, i + 2 * k - 1);
            i += 2 * k;
        }

        // 这段代码保证了，将那些“落单的”长度不足两两merge的部分和前面merge起来。
        if (i < n - k ) {
            merge(arr, i, i + k- 1, n - 1);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        // temp数组用于暂存合并的结果
        int[] temp = new int[high - low + 1];
        // 左半边的指针
        int i = low;
        // 右半边的指针
        int j = mid + 1;
        // 合并后数组的指针
        int k = 0;

        //将记录由小到大地放进temp数组
        for (; i <= mid && j <= high; k++) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i++];
            } else {
                temp[k] = arr[j++];
            }
        }

        //接下来两个while循环是为了将剩余的（比另一边多出来的个数）放到temp数组中
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= high) {
            temp[k++] = arr[j++];
        }

        //将temp数组中的元素写入到待排数组中
        for (int l = 0; l < temp.length; l++) {
            arr[low + l] = temp[l];
        }
    }
}
