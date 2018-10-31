package LinkedList.RemoveDuplicates;

/*
Hint: 非常简单，注意删除掉next结点的话就不用prev=prev.next了，删除结点时prev.next发生变化所以不用做什么，只有不删除时才向后移动，否则有可能空指针！
 */
public class RemoveLinkedListElements {
    //recursion
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        //传head.next下去
        head.next = removeElements(head.next, val);
        return head.value == val ? head.next : head;
    }

    //iteration
    public ListNode removeElements2(ListNode head, int val) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode curr = head, prev = fakeHead;

        while (curr != null) {
            if (curr.value == val) {
                prev.next = curr.next;
                //prev不需要移动，因为prev next变了，仍然是cur的前一个
            } else {
                //prev需要移动因为保持在cur的前一个
                prev = prev.next;
            }
            curr = curr.next;
        }
        return fakeHead.next;
    }
}
