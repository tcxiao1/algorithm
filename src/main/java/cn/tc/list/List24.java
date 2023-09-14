package cn.tc.list;

public class List24 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode node = swapPairs(node1);

        System.out.println(node);

    }

    public static ListNode swapPairs(ListNode head) {

        ListNode virNode = new ListNode(-1);
        virNode.next = head;

        ListNode first = null;
        ListNode second = null;
        ListNode temp = null;
        ListNode cur = virNode;

        while (cur.next != null && cur.next.next != null) {
            //交换
            first = cur.next;
            second = cur.next.next;
            temp = second.next;

            cur.next = second;
            second.next = first;
            first.next = temp;

            cur = first;
        }
        return virNode.next;
    }
}


//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4]   2 1 3 4
//输出：[2,1,4,3]
//
//
// 示例 2：
//
//
//输入：head = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：head = [1]
//输出：[1]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目在范围 [0, 100] 内
// 0 <= Node.val <= 100
//
//
// Related Topics 递归 链表 👍 2021 👎 0
