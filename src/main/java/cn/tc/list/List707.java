package cn.tc.list;

public class List707 {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
//        myLinkedList.addAtHead(1);
//        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(0, 10);
        myLinkedList.addAtIndex(0, 20);
        myLinkedList.addAtIndex(0, 30);
        myLinkedList.get(0);
//        myLinkedList.deleteAtIndex(1);
//        myLinkedList.get(1);

    }
}

class MyLinkedList {
    int count = 0;
    ListNode2 list;

    public MyLinkedList() {
    }

    /*
     * 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1 。
     * */
    public int get(int index) {
        if (index >= count || index < 0) {
            return -1;
        }
        int tmpIndex = 0;
        ListNode2 cur = list;
        while (tmpIndex != index) {
            cur = cur.next;
            tmpIndex++;
        }

        return cur.val;
    }

    /*
     * 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。
     * */
    public void addAtHead(int val) {
        if (count == 0) {
            list = new ListNode2(val);
        } else {
            while (list.pre != null) {
                list = list.pre;
            }
            ListNode2 head = new ListNode2(val);
            head.next = list;
            list.pre = head;
            list = head;
        }
        count++;
    }

    public void addAtTail(int val) {
        if (count == 0) {
            list = new ListNode2(val);
        } else {
            ListNode2 loop = list;
            while (loop.next != null) {
                loop = loop.next;
            }
            ListNode2 tail = new ListNode2(val);
            tail.pre = loop;
            loop.next = tail;
        }
        count++;
    }


    /*
    * 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。如果
        //index 等于链表的长度，那么该节点会被追加到链表的末尾。如果 index 比长度更大，该节点将 不会插入 到链表中。
    * */
    public void addAtIndex(int index, int val) {
        if (index > count || index < 0) {
            return;
        }

        int temIndex = 0;
        ListNode2 cur = list;
        ListNode2 pre = cur.pre;
        while (temIndex != index) {
            pre = cur;
            cur = cur.next;
            temIndex++;
        }

        ListNode2 addNode = new ListNode2(val);
        //如果index等于链表的长度
        if (index == count) {
            if (pre == null) {
                list = addNode;
            } else {
                pre.next = addNode;
                addNode.pre = pre;
            }
            count++;
            return;
        }

//1,2,3        处理前节点
        if (cur.pre != null) {
            cur.pre.next = addNode;
        }
        if (pre == null) {
            list = addNode;
        }
        addNode.next = cur;
        count++;
    }

    /*
     * 如果下标有效，则删除链表中下标为 index 的节点。
     * */
    public void deleteAtIndex(int index) {
        if (index >= count || index < 0) {
            return;
        }
        if (index == 0) {
            list = list.next;
            count--;
            return;
        }
        ListNode2 pre = list.pre;
        ListNode2 current = list;

        int tmpIndex = 0;
        while (tmpIndex != index) {
            pre = current;
            current = current.next;
            tmpIndex++;
        }
//1 2 3
        if (index == count - 1) {
            pre.next = null;
            list = pre;
            count--;
            return;
        }

        current.next.pre = pre;
        pre.next = current.next;
        count--;
    }
}
//20 30 10


class ListNode2 {
    int val;
    ListNode2 pre;
    ListNode2 next;

    ListNode2() {
    }

    ListNode2(int val) {
        this.val = val;
    }
}

//你可以选择使用单链表或者双链表，设计并实现自己的链表。
//
// 单链表中的节点应该具备两个属性：val 和 next 。val 是当前节点的值，next 是指向下一个节点的指针/引用。
//
// 如果是双向链表，则还需要属性 prev 以指示链表中的上一个节点。假设链表中的所有节点下标从 0 开始。
//
// 实现 MyLinkedList 类：
//
//
// MyLinkedList() 初始化 MyLinkedList 对象。
// int get(int index) 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1 。
// void addAtHead(int val) 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。
// void addAtTail(int val) 将一个值为 val 的节点追加到链表中作为链表的最后一个元素。
// void addAtIndex(int index, int val) 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。如果
//index 等于链表的长度，那么该节点会被追加到链表的末尾。如果 index 比长度更大，该节点将 不会插入 到链表中。
// void deleteAtIndex(int index) 如果下标有效，则删除链表中下标为 index 的节点。
//
//
//
//
// 示例：
//
//
//输入
//["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get",
//"deleteAtIndex", "get"]
//[[], [1], [3], [1, 2], [1], [1], [1]]
//输出
//[null, null, null, null, 2, null, 3]
//
//解释
//MyLinkedList myLinkedList = new MyLinkedList();
//myLinkedList.addAtHead(1);
//myLinkedList.addAtTail(3);
//myLinkedList.addAtIndex(1, 2);    // 链表变为 1->2->3
//myLinkedList.get(1);              // 返回 2
//myLinkedList.deleteAtIndex(1);    // 现在，链表变为 1->3
//myLinkedList.get(1);              // 返回 3
//
//
//
//
// 提示：
//
//
// 0 <= index, val <= 1000
// 请不要使用内置的 LinkedList 库。
// 调用 get、addAtHead、addAtTail、addAtIndex 和 deleteAtIndex 的次数不超过 2000 。
//
//
// Related Topics 设计 链表 👍 905 👎 0

