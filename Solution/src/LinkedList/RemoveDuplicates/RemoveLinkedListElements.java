package LinkedList.RemoveDuplicates;

/*
Hint: 非常简单，注意删除掉next结点的话就不用prev=prev.next了，删除结点时prev.next发生变化所以不用做什么，只有不删除时才向后移动，否则有可能空指针！
 */
public class RemoveLinkedListElements {
    //recursion
    public ListNode removeElements(ListNode head, int val) {
      //终结条件
        if (head == null) return null;
        //recursion，每一点都要做一个决策，这里是要不要删就好了
        //传head.next下去
        head.next = removeElements(head.next, val);

        //返回条件，做决策
        return head.value == val ? head.next : head;
    }

    //iteration
    public ListNode removeElements2(ListNode head, int val) {
        //还是考虑是不是要丢掉头的问题
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        //删除节点的问题，需要head的prev，但不是双向链表，所以需要记录一下prev
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
