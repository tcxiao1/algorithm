package cn.tc.list;

public class List19 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode node = removeNthFromEnd(node1, 2);

        System.out.println(node);

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        /*
         *
         *  可以基于快慢指针
         *
         * 定义慢指针和快指针 之间相差 n+1
         *
         * */
        if (head == null) {
            return null;
        }

        ListNode virNode = new ListNode(-1);
        virNode.next = head;

        ListNode cur = head;
        ListNode pre = virNode;
        ListNode removeNode = cur;

        for (int i = 0; i < n; i++) {
            removeNode = removeNode.next;
        }

        while (removeNode != null) {
            pre = cur;
            cur = cur.next;
            removeNode = cur;
            for (int i = 0; i < n; i++) {
                removeNode = removeNode.next;
            }
        }

        pre.next = cur.next;

        return virNode.next;
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {

        /*
         *
         *  可以基于快慢指针
         *
         * 定义慢指针和快指针 之间相差 n+1
         *
         * */

        ListNode virNode = new ListNode(-1);
        virNode.next = head;

        ListNode slow = virNode;
        ListNode fast = virNode;


        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return virNode.next;
    }
}


//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
//
//
// 示例 2：
//
//
//输入：head = [1], n = 1
//输出：[]
//
//
// 示例 3：
//
//
//输入：head = [1,2], n = 1
//输出：[1]
//
//
//
//
// 提示：
//
//
// 链表中结点的数目为 sz
// 1 <= sz <= 30
// 0 <= Node.val <= 100
// 1 <= n <= sz
//
//
//
//
// 进阶：你能尝试使用一趟扫描实现吗？
//
// Related Topics 链表 双指针 👍 2679 👎 0

