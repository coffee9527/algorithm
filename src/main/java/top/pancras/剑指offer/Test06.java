package top.pancras.剑指offer;

/**
 * Created by pancras on 2018/4/28 0028.
 *
 * 题目：输入某二叉树的前序遍历和中序遍历的结果(同时作为方法的参数)，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入
 * 前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6},
 * 则重建出如下的二叉树
 *             // 普通二叉树
 //              1
 //           /     \
 //          2       3
 //         /       / \
 //        4       5   6
 //         \         /
 //          7       8
 *
 *       二叉树结点的定义如下：
 *       struct BinaryTreeNode {
 *           int    value;
 *           BinaryTreeNode left;
 *           BinaryTreeNode right;
 *       }
 */

public class Test06 {
    /**
     * 二叉树节点类
     */
    public static class BinaryTreeNode{
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * @param preOrder
     * @param midOrder
     * @return 树的根节点
     */
    public static BinaryTreeNode construct(int[] preOrder, int[] midOrder) {
        //输入的合法性判断，两个数组都不能为空，并且都有数据，而且数据的数目相同
        if(preOrder == null || midOrder == null || preOrder.length != midOrder.length || midOrder.length < 1) {
            return null;
        }
        return construct(preOrder, 0, preOrder.length - 1, midOrder, 0, midOrder.length - 1);
    }

    /**
     * 输入某二叉树的前序遍历和中序遍历
     * @param preOder   前序遍历
     * @param ps        前序遍历的开始位置
     * @param pe        前序遍历的结束位置
     * @param miOrder   中序遍历
     * @param is        中序遍历的开始位置
     * @param ie        中序遍历的结束位置
     * @return          树的根结点
     */
    public static BinaryTreeNode construct(int[] preOder, int ps, int pe, int[] miOrder, int is, int ie) {
        //开始位置大于结束位置说明已经没有需要处理的元素了
        if(ps > pe) {
            return null;
        }

        //取前序遍历的第一个数字，就是当前的根结点
        int value = preOder[ps];
        int index = is;
        //在中序遍历的数组中找根节点的位置
        while(index <= ie && miOrder[index] != value) {
            index ++;
        }

        //如果在整个中序遍历的数组中没有找到，说明输入的参数是不合法的，抛出异常
        if(index > ie) {
            throw new RuntimeException("Invalid input");
        }

        //创建当前的根结点，并且为节点赋值
        BinaryTreeNode node = new BinaryTreeNode();
        node.value = value;

        //地归构建当前根结点的左子树，左子树的元素个数：index-is+1个
        //左子树对应的前序遍历的位置在[ps+1,ps+index-is]
        //左子树对应的中序遍历的位置在[is,index-1]
        node.left = construct(preOder, ps+1, pe+index-is, miOrder, is, index-1);
        // 递归构建当前根结点的右子树，右子树的元素个数：ie-index个
        // 右子树对应的前序遍历的位置在[ps+index-is+1, pe]
        // 右子树对应的中序遍历的位置在[index+1, ie]
        node.right = construct(preOder, ps+index-is+1, pe, miOrder, index+1, ie);

        return  node;
    }

    //中序遍历二叉树
    public static void printTree(BinaryTreeNode root) {
        if(root != null) {
            printTree(root.left);
            System.out.println(root.value + " ");
            printTree(root.right);
        }
    }

    // 普通二叉树
    //              1
    //           /     \
    //          2       3
    //         /       / \
    //        4       5   6
    //         \         /
    //          7       8
    private static void test1() {
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTreeNode root = construct(preorder, inorder);
        printTree(root);
    }

    // 所有结点都没有右子结点
    //            1
    //           /
    //          2
    //         /
    //        3
    //       /
    //      4
    //     /
    //    5
    private static void test2() {
        int[] preorder = {1, 2, 3, 4, 5};
        int[] inorder = {5, 4, 3, 2, 1};
        BinaryTreeNode root = construct(preorder, inorder);
        printTree(root);
    }

    // 所有结点都没有左子结点
    //            1
    //             \
    //              2
    //               \
    //                3
    //                 \
    //                  4
    //                   \
    //                    5
    private static void test3() {
        int[] preorder = {1, 2, 3, 4, 5};
        int[] inorder = {1, 2, 3, 4, 5};
        BinaryTreeNode root = construct(preorder, inorder);
        printTree(root);
    }

    // 树中只有一个结点
    private static void test4() {
        int[] preorder = {1};
        int[] inorder = {1};
        BinaryTreeNode root = construct(preorder, inorder);
        printTree(root);
    }

    // 完全二叉树
    //              1
    //           /     \
    //          2       3
    //         / \     / \
    //        4   5   6   7
    private static void test5() {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};
        BinaryTreeNode root = construct(preorder, inorder);
        printTree(root);
    }

    // 输入空指针
    private static void test6() {
        construct(null, null);
    }

    // 输入的两个序列不匹配
    private static void test7() {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 8, 1, 6, 3, 7};
        BinaryTreeNode root = construct(preorder, inorder);
        printTree(root);
    }

    public static void main(String[] args) {

        test1();
        System.out.println();
        test2();
        System.out.println();
        test3();
        System.out.println();
        test4();
        System.out.println();
        test5();
        System.out.println();
        test6();
        System.out.println();
        test7();

    }
}
