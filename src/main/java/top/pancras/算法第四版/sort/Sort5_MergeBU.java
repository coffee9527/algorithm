package top.pancras.算法第四版.sort;

/**
 * Created by pancras on 2018/5/3 0003.
 *
 * 自底向上归并
 *
 *      递归实现的归并时算法设计中分治思想的典型应用。我们将一个大问题分割成小问题分别解决，然后用所有小问题的答案
 *  来解决整个大问题。尽管我们考虑的问题时归并两个大数组，实际上我们归并的数组大多数都非常小。实现归并排序的另一种
 *  方法是先归并那些微型数组，然后再成对归并得到的子数组，比如这般，直到我们将整个数组归并在一起。这种实现方法比标
 *  准归并方法所需的代码量更少。首先我们进行的事两两碓冰（把每个元素想象成一个大小为1的数组），然后是四四归并（将两
 *  个大小为2的数组归并成一个有4个元素的数组），然后是八八归并，一直下去。在每一轮归并中，最后一次归并的第二个子数组
 *  可能比第一个子数组要小（但这对merge()方法不是问题），如果不是的话所有的归并中两个数组大小都应该一样，而在下一轮中
 *  子数组的大小会翻倍。实现如下
 */
public class Sort5_MergeBU extends MergeAbstract{

    private Sort5_MergeBU() {}

    public static void sort(Comparable[] a) {
        //进行logN次两两归并
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz+sz)                //sz子数组大小
            for (int lo = 0; lo < N - sz; lo += sz + sz)    //lo：子数组索引
                merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
    }
}
