package top.pancras.算法第四版.sort;

import java.io.PrintStream;

/**
 * Created by pancras on 2018/5/2 0002.
 *
 * 该类是排序算法类的模板,该模板适用于任何实现了Comparable接口的数据类型。
 * 默认从小到大排序
 *
 *      本类是包含静态方法实现的抽象，因为算法主要是作为工具类来使用，非常不建议通过构造方法来创建算法对象，
 *  因此不得不使用静态方法,而静态方法在是无法定义没有方法体的抽象方法的，无法强制子类实现，只能子类主动实现了。
 *  这也是使用抽象类来定义而不是接口的原因
 */
public  abstract class SortTemplate {
   protected static PrintStream out = System.out;

//      //此处需要子类来实现一个sort方法，以此来编写具体的算法
//   public static void sort(Comparable[] a) {
//
//   };

    protected static boolean less(Comparable v, Comparable w){
       return v.compareTo(w) < 0;
   }

    protected static void exch(Comparable[] a, int i, int j) {
       Comparable t = a[i]; a[i] = a[j]; a[j] = t;
   }

    protected static void show(Comparable[] a) {
       //在单行中打印数组
       for(int i=0; i < a.length; i++)
           out.print(a[i] + " ");
       out.println();
   }
    protected static boolean isSorted(Comparable[] a) {
       //测试数组元素是否有序
       for(int i = 1; i < a.length; i++)
           if(less(a[i], a[i-1])) return false;
       return true;
   }
}
