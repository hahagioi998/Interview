package LinkedList.ReversalAndRotation;
/*
Hint: 这道题用上面提到的“头插法”的话非常简单：因为最后一组保持不变，所以先获得链表长度看看需要reverse几组，然后对每组都执行“头插法”。
把“头插法”提取为一个子方法，代码变得异常清晰！
*/
public class ReverseKGroups {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        int len = 0;
        for (ListNode n = head; n != null; n = n.next) {
            len++;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        //用这种除法，相当于余数就不用reverse了
        for (int i = 0; i < len / k; i++) {
            prev = reverseK(prev, k);
        }
        return dummy.next;
    }

    // Perform K-1 reversals for K group
    private ListNode reverseK(ListNode prev, int k) {
        ListNode cur = prev.next;

        if (cur != null) {      // when len is divisible by k, no node left in last batch
            while (k-- > 1) {
                ListNode then = cur.next;
                cur.next = then.next;
                then.next = prev.next;
                prev.next = then;
            }
        }
        //cur就是反转之后的尾，也是下一段的前一个
        return cur;
    }


    public ListNode reverseKGroup2(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //起到了cur的作用，head是要reverse的nodes的前一个
        head = dummy;

        //查看的一定是尾
        while (head.next != null) {
            head = reverseNextK(head, k);
        }

        return dummy.next;
    }

    // reverse head->n1->..->nk->next..
    // to head->nk->..->n1->next..
    // return n1
    private ListNode reverseNextK(ListNode head, int k) {
        //head的位置是不动的
        // check there is enought nodes to reverse
        ListNode next = head; // next is not null
        for (int i = 0; i < k; i++) {
            if (next.next == null) {
                //返回最后一个值
                return next;
            }
            next = next.next;
        }

        // reverse，head，n1的位置没有动
        // n1是转了以后的尾巴，cur是prev后面的那个
        //prev和curt
        ListNode n1 = head.next;
        ListNode prev = head, curt = n1;
        for (int i = 0; i < k; i++) {
            ListNode temp = curt.next;
            curt.next = prev;
            prev = curt;
            curt = temp;
        }
        //123 4-》321 4
        //n1就是1，curt是4
        n1.next = curt;
        //prev是3
        head.next = prev;
        return n1;
    }
}
