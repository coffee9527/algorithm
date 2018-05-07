package top.pancras.算法第四版.sort;

import sun.text.normalizer.NormalizerBase;

import java.io.PrintStream;
import java.util.Random;

/**
 * Created by pancras on 2018/5/4 0004.
 *
 * 三向切分排序改进
 *
 *      快速排序发布后并没有流行开来，因为在数组中重复元素不多的普通情况下它比标准的二分法多使用了很多次交换。
 *  90年代，J.Bently和D.Mellroy找到一个聪明的方法解决了这个问题，使得三向切分的快速排序比归并排序和其他排序
 *  方法在包括重复元素很多的实际应用中更快。本类就是这种改进的实现
 *      归并元素对于任意输入的数组来说是最优的排序了，但对包含很多重复元素的特定输入来说是无法保证最佳性能。
 */
public class Sort8_QuickBentleyMcIlroy extends SortTemplate{
    //cutoff(中断) to insertion sort, must be > 1
    private static final int INSERTION_SORT_CUTOFF = 8;

    //cutoff to median-of-3 partitioning
    private static final int MEDIAN_OF_3_CUTOFF = 40;

    //This class should not be instantiated.
    private Sort8_QuickBentleyMcIlroy() {}

    /**
     * Rearrange the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        sort(a, 0, a.length-1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        int n = hi - lo + 1;
        //cutoff to insertion sort
        if (n <= INSERTION_SORT_CUTOFF) {
            insertionSort(a, lo, hi);
            return;
        }//use median-of-3 as partitioning element
        else if(n <= MEDIAN_OF_3_CUTOFF) {
            int m = median3(a, lo, lo + n/2, hi);
            exch(a, m, lo);
        }else {
            int eps = n/8;
            int mid = lo + n/2;
            int m1 = median3(a, lo, lo + eps, lo + eps + eps);
            int m2 = median3(a, mid - eps, mid, mid + eps);
            int m3 = median3(a, hi -eps - eps, hi - eps, hi);
            int ninther = median3(a, m1, m2, m3);
            exch(a, ninther, lo);
        }
        //Bentley-McIlroy 3-way partitioning
        int i = lo, j = hi + 1;
        int p = lo, q = hi + 1;
        Comparable v= a[lo];
        while (true) {
            while (less2(a[++i], v))
                if(i == hi)
                    break;
            while (less2(v, a[--j]))
                if (j ==lo)
                    break;
            //pointers cross
            if(i == j && eq(a[i], v))
                exch(a, ++p, i);
            if (i >= j)
                break;

            exch(a, i, j);
            if (eq(a[i], v))
                exch(a, ++p, i);
            if (eq(a[j], v))
                exch(a, --q, j);
        }
        i = j + 1;
        for (int k = lo; k <= p; k++)
            exch(a, k, j--);
        for (int k = hi; k >= q; k--)
            exch(a, k, i++);

        sort(a, lo, j);
        sort(a, i, hi);
    }

    //sort from a[lo] to a[hi] using insertin sort
    private static void insertionSort(Comparable[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++)
            for(int j=i; j>lo && less2(a[j], a[j-1]);j--)
                exch(a, j, j-1);
    }

    // is v < w ?
    private static boolean less2(Comparable v, Comparable w) {
        if (v == w) return false;    // optimization when reference equal
        return v.compareTo(w) < 0;
    }

    //return the index of the median element among a[i], a[j], and a[k]
    private static int median3(Comparable[] a, int i, int j, int k) {
        return (less2(a[i], a[j]) ?
                (less2(a[j], a[k]) ? j : less2(a[i], a[k]) ? k : i) :
                (less2(a[k], a[j]) ? j : less2(a[k], a[i]) ? k : i));
    }

    //does v == w
    private static boolean eq(Comparable v, Comparable w) {
        if(v == w) return true;
        return v.compareTo(w) == 0;
    }

}
