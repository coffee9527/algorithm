package top.pancras.算法第四版.sort;

/**
 * Created by pancras on 2018/5/3 0003.
 *
 * 自顶向下归并
 */
public class Sort4_MergeUB extends MergeAbstract {

    private Sort4_MergeUB() {}

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length]; //一次性分配空间
        sort(a, 0, a.length - 1);
    }

    /**
     * 实现排序
     * @param a     要排序的数组
     * @param lo    归并起始位置
     * @param hi    归并结束位置
     */
    private static void sort(Comparable[] a, int lo, int hi) {
        //将数组a[lo..hi]排序
        if(hi <= lo)//递归调用结束条件
            return;
        int mid = lo + (hi -lo)/2;
        sort(a, lo, mid);   //递归调用，将左半边排序
        sort(a, mid+1, hi);//递归调用，将右半边排序
        merge(a, lo, mid, hi);
    }

}
