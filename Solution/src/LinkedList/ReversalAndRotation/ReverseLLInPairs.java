package LinkedList.ReversalAndRotation;
/*
Hint: 很简单的一道题，将swap(prev)单独拆出来作为一个函数会比较清晰。
不变量是：prev（包括它自身）之前的结点都Swap完成，这样循环结束时（prev到达末尾）就完成了整个链表的Swap。

 */
//要连几次箭头就是几步反转，其他的要记录开头，移动ptr
//1->2->3->4  cur = dummy next = 2
//1->3      从最开头向前连   （head.next = reverse())
//2->1
//cur->2->1->3->4
//2->1->3->4 cur = 1
//或者当成reverse k groups，k = 2
public class ReverseLLInPairs {
    public ListNode reverseInPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode current = dummy;

        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;

            first.next = second.next;
            second.next = first;
            current.next = second;
            current = first;
        }
        return dummy.next;
    }

//        Method2：(每层处理两个node，reverse以后第二个node就是newhead）
//        ListNode newHead = head.next; //每次返回给上一层的就是第二个node，是新的head 比如这里就是2
//        head.next = reverseInPairs(head.next.next); // 1->3
//        newHead.next = head;  // 2->1
//        return newHead; //返回2


    public void display(ListNode head) {
        ListNode currNode = head;
        while (currNode != null) {
            System.out.print("->" + currNode.value);
            currNode = currNode.next;
        }
    }

    public static void main(String[] args){
        ReverseLLInPairs sol = new ReverseLLInPairs();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        sol.display(sol.reverseInPairs(head));
//        sol.display(head);
    }
}


