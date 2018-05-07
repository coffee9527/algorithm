package top.pancras.tree;

/**
 * Created by pancras on 2018/5/2 0002.
 *==============参考：数据结构与算法分析_Java语言描述(第2版)
 * 树的几个概念：
 *      根节点
 *      子节点
 *      树叶
 *      兄弟节点
 *      祖孙节点
 *      路径
 *      深度
 *      高
 *      祖先
 *      后裔
 *      真祖先
 *      真后裔
 *
 * 树可以用多种方式定义：
 *      定义树的一种自然的方式是地归的方式。一棵树是一些节点的集合。这个集合可以是空集；若不是空集，则树由
 *  称作根(root)的几点r以及0个或多个非空的子树T1,T2,T3...,TK组成。这些子树中每一棵的根都被来自根r的一条又向
 *  的边所连接。
 *
 */

//树的声明
class TreeNode<T> {
    T element;
    TreeNode<T> firstChild;
    TreeNode<T> nextsibling;
}
//二叉树
class BinaryNode<T> {
    T element;
    BinaryNode<T> left;
    BinaryNode<T> right;
}
public class TreeDemo {

}
