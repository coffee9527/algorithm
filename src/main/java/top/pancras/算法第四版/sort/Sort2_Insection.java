package top.pancras.算法第四版.sort;

/**
 * Created by pancras on 2018/5/2 0002.
 *
 * 插入排序
 *
 * 定义：
 *      当一个新元素要插入到已有序数组中的适当位置时，为了给要插入的元素腾出空间，我们需要将其余所有元素在插入之前都向右移动一位。这种算法叫做插入排序。
 *
 *  规律：
 *      1.对于随机排列的长度为N且逐渐不重复的数组，平均情况下插入排序需要大约N*N/4次比较以及大约N*N/4次交换。最坏情况
 *  需要大约N*N/2次交换，最好情况下需要N-1次比较和0次交换。
 *      2.插入排序需要的交换操作和数组中倒置的数量相同，需要的比较次数大于等于倒置(与排序顺序相反)的数量，小于倒置的
 *  数量加上数组的大小再减一。
 *
 *  插入排序的效率和输入的数组特点有关，对部分有序的数组十分有效
 */
public class Sort2_Insection extends SortTemplate{
    private Sort2_Insection(){}
    public static void sort(Comparable[] a) {
        //将a[]按升序排列
        int N = a.length;
        for(int i = 1; i < N; i++) {
            //将a[i]插入到a[i-1],a[i-2],a[i-3]...之中
            for(int j = i; j > 0 && less(a[j],a[j-1]); j--)
                exch(a, j, j-1);
        }
    }
}
