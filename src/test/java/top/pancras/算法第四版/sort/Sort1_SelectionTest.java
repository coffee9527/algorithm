package top.pancras.算法第四版.sort;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by pancras on 2018/5/4 0004.
 * 选择排序简单测试
 */
public class Sort1_SelectionTest {
    @Test
    public void sort() throws Exception {
        PrintStream out = System.out;
        Integer N = 100000;//数组大小
        int scope = 50;  //元素值的范围

        out.println("开始创建数组...");
        //创建一个长度大于8的数组，因为小于8他会直接拿使用插入排序
        Integer[] arr = new Integer[N];
        Random random = new Random();
        for (int i=0; i<N;i++) {
            arr[i] = random.nextInt(scope);
        }
        out.println("开始打印数组...");
        //打印创建出的数组
        SortTemplate.show(arr);
        out.println();
        out.println("开始对数组排序...");
        long start = System.currentTimeMillis();
        Sort1_Selection.sort(arr);
        long time = System.currentTimeMillis() - start;
        out.println("=================打印排序结果================");
        SortTemplate.show(arr);
        out.println();
        out.println("所用时间：" + time);//8504ms
    }

}