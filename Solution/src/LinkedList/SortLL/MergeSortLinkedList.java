package LinkedList.SortLL;

public class MergeSortLinkedList {
    //findmiddle
    private ListNode findMiddle(ListNode head) {
        //这是另一种find middle的方法 和slow = head，fast= head，while (fast != null && fast.next != null) 一样的
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        //要创建一个新head
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        //谁小移谁
        while (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        //剩下的部分
        if (head1 != null) {
            tail.next = head1;
        } else {
            tail.next = head2;
        }

        return dummy.next;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = findMiddle(head);

        ListNode right = sortList(mid.next);
        //要断开
        mid.next = null;
        ListNode left = sortList(head);

        return merge(left, right);
    }
}
