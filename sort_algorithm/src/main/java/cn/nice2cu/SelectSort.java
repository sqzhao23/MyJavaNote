package cn.nice2cu;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @author: zhaoshiqiu
 * @create: 2020-11-02 11:32
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] array = {20, 36, 2, 69, 87, 3, 15, 14, 22};

        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(selectSort(array)));
    }

    /**
    * 选择排序
    * @param sourceArray 原数组
    * @return int[]
    */
    public static int[] selectSort(int[] sourceArray) {
        // 对array进行拷贝, 不改变参数内容;
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        // 两两比较, 进行n-1轮比较;
        for (int i = 0; i < arr.length - 1; i++) {
            // 最小元素的下标;
            int min = i;
            // 每一轮比较n - i次;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[min]) {
                    min = j;
                }
            }
            // 将找到的最小元素和第i个元素交换;
            if (i != min) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        return arr;
    }
}
