package top.pancras.剑指offer; /**
 * Created by pancras on 2018/4/27 0027.
 */
/*
题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照
从上到下递增的顺序排列，请完成一个函数，输入这样的一个二维数组和一个
整数，判断数组中是否有该整数。
 */

/**
 * 分析：
 *      如下二位数组符合题目要求，应该必须是矩形的二位数组才符合要求吧，不然下面的解法会有问题
 *              1    2   8   9
 *              2   4   9   12
 *              4   7   10  13
 *              6   8   11  15
 *
 *      可能我们刚开始会思考左上角到右下角的数据(1,4,10,15)来和要查找的数据x进行比较，我觉得
 *      这样只能很好的判断边界，但貌似做查找的话也不太好做，因为不论比较结果如何，横行和列行
 *      都依然有可能存在要查找的数
 *      如果换一个角度也许就简单啦，从右上角往左下角看(9,9,7,6)，如果x比右上角a的数要小，则剔除a
 *      所在的列，如果x比a大，则提出a所在的行，这样可以有方向的缩小范围
 */
public class Test03 {

    public static void main(String[] args) {
        //要测试的输入数组
        int[][] arr1 = null;
        int[][] arr2 = new int[2][3];//原始类型初始化后其初始值为0，所以0必然可以查到
        int[][] arr3 = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        int[][] matrix = {
                {1, 2, 8, 11, 13, 16},
                {2, 4, 9, 12, 14, 15},
                {4, 7, 10, 13, 15, 19},
                {6, 8, 11, 15, 16, 20}
        };
        //===========================测试isInclud====================

        System.out.println(isInclud(arr1, 0));
        System.out.println(isInclud(arr2, 0));
        System.out.println(isInclud(arr3, 6));
        System.out.println(isInclud(matrix, 6));
        System.out.println("-------------------------------");
        //============================测试isInclud2=====================
        System.out.println(isInclud2(arr1, 0));
        System.out.println(isInclud2(arr2, 0));
        System.out.println("-------------------------------");
        System.out.println(isInclud2(arr3, 1));
        System.out.println(isInclud2(arr3, 2));
        System.out.println(isInclud2(arr3, 3));
        System.out.println(isInclud2(arr3, 4));
        System.out.println(isInclud2(arr3, 6));
        System.out.println("-------------------------------");
        System.out.println(isInclud2(matrix, 1));
        System.out.println(isInclud2(matrix, 2));
        System.out.println(isInclud2(matrix, 16));
        System.out.println(isInclud2(matrix, 8));
        System.out.println(isInclud2(matrix, 6));

    }

    /**
     * 一般方式，适用于所有二维数组，但效率低下
     * @param arr2
     * @param x
     * @return
     */
    private static boolean isInclud(int[][] arr2, int x) {
        if (arr2 == null) return false;
        for (int[] arr1 : arr2)
            for (int k : arr1)
                if (k == x) return true;

        return false;
    }

    /**
     * 适用于题目所描述的数组，效率高
     * @param matrix
     * @param number
     * @return
     */
    private static boolean isInclud2(int[][] matrix, int number) {
        if(matrix == null || matrix.length < 1 || matrix[0].length<1) {
            return false;
        }

        int rows = matrix.length;//数组的行数
        int cols = matrix[1].length;//数组行的列数

        int row = 0;//起始的行号
        int col = cols -1;//起始的列号
        //要查找的数确保在数组覆盖的范围之内

        //要查找的位置确保在数组之内
        while (row >= 0 && row < rows && col >=0 && col <cols) {
            if (matrix[row][col] == number) { //如果找到了就直接退出
                return true;
            }
            if(matrix[row][col] > number) {//如果找到的数比要找的数大，说明要找的数在当前数的左边
                col--;//列数减一，代表向左移动
            }else {
                row++;//行数加一，代表向下移动
            }
        }
        return false;
    }
}
