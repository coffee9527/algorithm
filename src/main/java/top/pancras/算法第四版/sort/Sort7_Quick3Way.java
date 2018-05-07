package top.pancras.算法第四版.sort;

/**
 * Created by pancras on 2018/5/4 0004.
 *
 * 快速排序改进之三向切分的快速排序
 *
 *      这是改进后的快速排序，它从左到右遍历数组一次，维护一个指针lt使得a[lo..lt-1]中的元素都小于v，一个
 *  指针gt使得a[gt+1..hi]中的元素都大于v，一个指针i使得a[lt..i-1]中的元素都等于v，a[i..gt]中的元素都还未
 *  确定。一开始i和lo相等，我们使用Comparable接口(而非less())对a[i]进行三向比较来直接处理以下情况：
 *      (1)a[i]小于v，将a[lt]和a[i]交换，将lt和i加一
 *      (2)a[i]大于v，将a[gt]和a[i]交换，将gt减一
 *      (3)a[i]等于v，将i加一
 *      这些操作都会保证数组元素不变且缩小gt-i的值(这样循环才会结束)。另外，除非和切分元素相等，其他元素
 *  都会被交换
 *
 *  改进：
 *      参考类 Sort8_QuickBentleyMcIlroy
 */
public class Sort7_Quick3Way extends SortTemplate{
    private Sort7_Quick3Way() {
    }

    public static void sort(Comparable[] a) {
        //TODO 消除对输入的依赖 StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if(hi <= lo)
            return;
        int lt = lo, i = lo+1,gt = hi;
        Comparable v = a[lo];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0)
                exch(a, lt++, i++);
            else if (cmp > 0)
                exch(a, i, gt--);
            else
                i++;
        }
        sort(a, lo, lt-1);
        sort(a, gt+1, hi);
    }
}
