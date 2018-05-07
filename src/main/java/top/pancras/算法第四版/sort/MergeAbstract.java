package top.pancras.算法第四版.sort;

/**
 * Created by pancras on 2018/5/3 0003.
 *
 * 原地归并排序抽象
 *
 *
 *      归并排序算法是基于归并这个简单的操作，即将两个有序的数组归并成一个更大的有序数组。很快人们就根据这个操作
 *  发明了一种简单的递归排序算法：归并排序。需要将一个数组排序，可以先（递归地）将它分成两半分别排序，然后将结果归并起来。
 *  你讲会看到，归并排序最吸引人的性质是他能够保证任意长度为N的数组排序所需和NlogN成正比；它的主要确定则是它所需的
 *  额外控件和N成正比。
 *      实现归并的一种直截了当的办法是将两个不同的有序数组归并到第三个数组中，两个数组中的元素应该都实现了Comparable接口。
 *  实现的方法很简单。创建一个适当大小的数组然后将两个输入数组中的元素一个个从小到大放入这个数组中。
 *      但是，当用归并将一个大数组排序时，我们需要进行很多次归并，因此在每次归并时都创建一个新书组来存储排序结果会带来问题。
 *  我们更希望有一种能够在原地归并的方法，这样就可以现将前半部分排序，再将后半部分排序，然后在数组中移动元素而不需要使用额外
 *  的空间。你可以先停下来想想应该如何实现这一点，乍一看很容易做到，但实际上已有的实现都非常复杂，尤其是和使用额外控件的方法
 *  相比。
 *      尽管如此，将原地归并抽象化时有帮助的。与之对应的是我们的方法签名merge(a, lo, mid, hi),它会将子类数组a[lo..mid]和
 *      a[mid+1..hi]归并成一个有序的数组并将结果存放在a[lo..hi]中。下面的几行代码就实现了这种归并
 *
 */
public abstract class MergeAbstract extends SortTemplate{
    protected static Comparable[] aux; //归并所需的辅助数组

    /**
     * 归并排序的抽象
     * @param a     要排序的数组
     * @param lo    归并的起始位置lower
     * @param mid   归并的中间位置
     * @param hi    归并的结束位置high
     */
    protected static void merge(Comparable[] a, int lo, int mid, int hi) {
        //将a[]o..mid]和a[mid+1..hi]归并
        int i= lo, j = mid + 1;
        for(int k = lo; k <= hi; k++)   //将a[lo..hi]复制到aux[lo..hi]
            aux[k] = a[k];

        for(int k = lo; k <= hi; k++) //归并回到a[lo..hi]
            if (i > mid)        //如果左半部分先并完那么就开始归并右半部分
                a[k] = aux[j++];
            else if (j > hi)    //如果右半部分先归并完那么就开始归并左半部分
                a[k] = aux[i++];
            else if(less(aux[j], aux[i]))//通过比较左右部分的大小进行归并
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
    }

}
