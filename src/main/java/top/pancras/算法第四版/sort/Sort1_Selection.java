package top.pancras.算法第四版.sort;

/**
 * Created by pancras on 2018/5/2 0002.
 *
 * 选择排序
 *
 * 定义：
 *      一种最简单的排序算法是这样的：首先，找到数组中最小的那个元素，其次，将它和数组的第一个元素交换位置（如果第一个）
 * 元素就是最小元素那么它就和自己交换）。再次，在剩下的元素中找到最小的元素，将它与数组的第二个元素交换位置。如此往复，
 * 直到将整个数组排序。这种方式叫做选择排序，因为它在不断地选择剩余元素之中的最小者。
 *
 *  规律：
 * 对于长度为N的数组，选择排序需要大约N*N/2次比较和N次交换
 *
 *  特点：
 *  选择排序有两个鲜明的特点
 *      运行时间和输入无关：一个有序数组和无序数组的排序时间基本一样
 *      每次交换数据移动是最少的：每次交换都会改变两个数组元素的值
 */
public class Sort1_Selection extends SortTemplate {
    private Sort1_Selection(){}
    public static void sort(Comparable[] a) {
        //将a[]按升序排序
        int N = a.length;   //数组长度
        for(int i = 0; i < N; i++) {
            //将a[i]和a[i+1...N]中最小的元素交换
            int min = i;
            for(int j = i + 1; j < N; j++)
                if (less(a[j], a[min])) min = j;
            exch(a, i, min);
        }
    }


}
