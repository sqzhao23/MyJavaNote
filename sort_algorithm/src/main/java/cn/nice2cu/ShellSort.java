package cn.nice2cu;

import java.util.Arrays;

/**
 * 希尔排序
 *
 * @author: zhaoshiqiu
 * @create: 2020-11-02 18:15
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] array = {20, 36, 2, 69, 87, 3, 15, 14, 22};

        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(shellSort(array)));
    }

    /**
    * 希尔排序
    * @param sourceArray 原数组
    * @return int[]
    */
    public static int[] shellSort (int[] sourceArray) {
        // 对array进行拷贝, 不改变参数内容;
        int[] arr  = Arrays.copyOf(sourceArray, sourceArray.length);

        int length = arr.length;
        int temp;

        for (int step = length / 2; step >= 1; step /= 2) {

            //在相隔各个增量的数进行插入排序
            for (int i = step; i < length; i++) {
                temp = arr[i];
                int j = i - step;
                while (j >= 0 && arr[j] > temp) {
                    arr[j + step] = arr[j];
                    j -= step;
                }
                // 上面出while循环多减了一个step, 这里需要加一个回来确保在范围内;
                arr[j + step] = temp;
            }
        }
        return arr;
    }
}
