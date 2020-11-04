package cn.nice2cu;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author: zhaoshiqiu
 * @create: 2020-11-02 14:43
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] array = {20, 36, 2, 69, 87, 3, 15, 14, 22};

        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(insertSort(array)));
    }

    /**
    * 插入排序
    * @param sourceArray 原数组
    * @return int[]
    */
    public static int[] insertSort(int[] sourceArray) {
        // 对array进行拷贝, 不改变参数内容;
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        // 从第二个元素开始为无序元素选择合适的位置进行插入;
        for (int i = 1; i < arr.length; i++) {
            // 记录将被插入元素;
            int temp = arr[i];
            // 从有序序列的右边第一个元素开始比较;
            int j = i;
            while (j > 0 && temp < arr[j - 1]) {
                arr[j] = arr[j-1];
                j--;
            }
            //如果存在比其小的数, 插入;
            if (j != i) {
                arr[j] = temp;
            }
        }
        return arr;
    }
}
