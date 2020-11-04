package cn.nice2cu;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author: zhaoshiqiu
 * @create: 2020-11-02 10:36
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {20, 36, 2, 69, 87, 3, 15, 14, 22};

        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(bubbleSort(array)));
    }

    /** 
    * 冒泡排序
    * @param sourceArray 原数组
    * @return int[]
    */
    public static int[] bubbleSort(int[] sourceArray) {
        // 对array进行拷贝, 不改变参数内容;
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        for (int i = 1; i < arr.length; i++) {

            // 设置flag, 如果提前排序完成, 则退出循环;
            boolean flag = true;

            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return arr;
    }

}
