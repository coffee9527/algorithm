package top.pancras.剑指offer;

import java.io.PrintStream;
import java.util.Stack;

/**
 * Created by pancras on 2018/4/28 0028.
 *
 * 题目：输入一个链表的头结点，从尾到头打印出每个节点的值
 * 分析：该链表只能单向查找，所以我的思路就是先从头到尾遍历链表，并存储到
 */
public class Test05 {
    /**
     * 链表
     */
    private static class ListNode {
        int value;
        ListNode next;
    }
    //main方法
    public static void main(String[] args) {
        PrintStream printStream = System.out;
        ListNode ln = new ListNode();
        ln.value = 1;
        ListNode first = ln;
        for (int i=1; i<100000;i++) {
            ln.next = new ListNode();
            ln.next.value = i + 1;
            ln = ln.next;
        }
        long start = System.currentTimeMillis();
        //reverseListNode(first);//time:14ms/89/715
        ListNode newNode = reverse(first);//time:10ms/92/java.lang.StackOverflowError
        //ListNode newNode = reverse2(first);//time:17/104/596
        while(newNode!=null){
            printStream.println(newNode.value);
            newNode=newNode.next;
        }
        //printListInverselyUsingIteration(first);//time:12ms/52/400
        //printListInverselyUsingRecursion(first);//time:9ms/92/StackOverflowError
        printStream.println(System.currentTimeMillis() - start);
    }

    /**
     * 我的方法，思路：将原链表node中的值逆序放入新链表first中，再遍历first中，
     * 该方式的一个明显缺点是要不断创建新的ListNode对象，但是没有破坏原数据结构
     * @param node
     */
    private static void reverseListNode(ListNode node) {
        PrintStream printStream = System.out;
        //创建数组的话要知道链表的长度才行
        ListNode ln = null;
        ListNode first = new ListNode();
        while(node!=null) {
            first.value = node.value;
            ln = new ListNode();
            ln.next = first;
            first = ln;
            node = node.next;
        }
        first = first.next;
        while (first != null) {
            printStream.println(first.value);
            first = first.next;
        }
    }

    //地归方式，不推荐，容易造成内存溢出
    private static ListNode reverse(ListNode head) {
        if(head.next==null){
            return head;
        }
        ListNode reverseHead=reverse(head.next);
        head.next.next = head;
        head.next = null;

        return reverseHead;

    }
    //这种方式不错，它通过遍历直接使链表的指向顺序变成了逆向,在次过程中没有创建新的对象，效率高。
    // 一个小问题就是该方式破坏了原来的数据结构
    private static ListNode reverse2(ListNode head) {
        ListNode pre=head;
        ListNode cur=head.next;
        ListNode temp;
        while(cur!=null){
            //暂存一下cur.next
            temp=cur.next;
            //改变cur.next的指向，使他指向前一个结点
            cur.next = pre;
            //使pre前进一个节点
            pre=cur;
            //cur前进一个节点
            cur=temp;
        }
        head.next = null;
        return pre;
    }


    /**
     * 输入个链表的头结点，从尾到头反过来打印出每个结点的值
     * 使用栈的方式进行
     *
     * @param root 链表头结点
     */
    public static void printListInverselyUsingIteration(ListNode root) {
        Stack<ListNode> stack = new Stack<ListNode>();
        while (root != null) {
            stack.push(root);
            root = root.next;
        }
        ListNode tmp;
        while (!stack.isEmpty()) {
            tmp = stack.pop();
            System.out.print(tmp.value + " ");
        }
    }

    /**
     * 输入个链表的头结点，从尾到头反过来打印出每个结点的值
     * 使用栈的方式进行
     *  地归方式，不推荐，容易造成内存溢出
     * @param root 链表头结点
     */
    public static void printListInverselyUsingRecursion(ListNode root) {
        if (root != null) {
            printListInverselyUsingRecursion(root.next);
            System.out.print(root.value + " ");
        }
    }
}
