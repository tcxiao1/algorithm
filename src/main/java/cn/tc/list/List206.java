package cn.tc.list;

public class List206 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode node = reverseList(node1);
        System.out.println(node);
    }

    public static ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode curent = head;
        ListNode temp = null;


        while (curent != null) {
            temp = curent.next;

            curent.next = pre;
            pre = curent;

            curent = temp;
        }

        return pre;
    }
}

/*
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 *
 * 输入：head = [1,2,3,4,5]
   输出：[5,4,3,2,1]
 *
 * */

