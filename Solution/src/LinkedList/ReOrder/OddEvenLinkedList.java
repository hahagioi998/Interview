package LinkedList.ReOrder;
/*
Example:
        Given 1->2->3->4->5->NULL,
        return 1->3->5->2->4->NULL.
        Hint: 这种不是删除结点而是移动重新插入结点的问题要注意：prev/cur等游标指针的移动，是不是后面结点被移走了就不用移动了，是不是后面结点移走了就null了等等。
        */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null) return head;

            ListNode odd = head, even = head.next, evenHead = even;

            //奇偶数的问题，奇数的时候even最后会是null
            while (even != null && even.next != null) {
                odd.next = odd.next.next;
                even.next = even.next.next;

                odd = odd.next;
                even = even.next;
            }
            odd.next = evenHead;

        return head;
    }
}
