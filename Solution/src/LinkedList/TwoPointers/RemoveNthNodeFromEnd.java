package LinkedList.TwoPointers;

//Given linked list: 1->2->3->4->5, and n = 2.
//取决于slow的位置
//fast= head， fast走n之后，就到了第n+1个node，如果是odd那么就会停在NthNodeFromEnd的前一个，因为还剩下n个node，2，even就会在NthNodeFromEnd，还剩下2n-(n+1)= n - 1个node
//fast如果从dummy开始，就要走n+1次
//如果slow = dummy, fast之后到null，slow就会停在NthNodeFromEnd的前一个
//如果slow = head, fast到null，slow就会正好在NthNodeFromEnd，所以不可取
//After removing the second node from the end, the linked list becomes 1->2->3->5.
//分析：因为我们想要的结果是cur=null同时nprev指向Nth的前一个，也就是说两者之间有n个结点（这就是Invariant）。于是nprev等到cur已经走到n+1时再开始跟着走，这样就保证两者相隔n个结点，循环结束时也就达到我们想要的结果了。

public class RemoveNthNodeFromEnd {
    //这个方法棒，fast从dummy开始走，走到null
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // 1.Find prev of nth node: there're n nodes between (nprev, cur)
        // -> when terminating (cur=null), nprev is previous node of nth
        // eg.[1,2,3,4,5], n=2: nprev=3, cur=null
        ListNode nprev = dummy, cur = dummy;
        //考虑的是走的次数
        for (int i = 0; cur != null; i++) {
            if (i >= n + 1) {       // Prove: nprev starts off when cur is already N+1 away -> #nodes in the middle = cur - nprev - 1 = n
                nprev = nprev.next;
            }
            cur = cur.next;
        }

        // 2.Delete nth node: nprev is at least dummy, which means delete first node
        // given n is always valid -> exclude the case n is too large or even negative
        nprev.next = nprev.next.next;
        return dummy.next;
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);//because fist node could be removed
        dummy.next = head;
        ListNode slow = dummy, fast = head;

        for (int i = 0; i < n; i++) {
            if (fast == null) {//need to check if n is larger than the length！！！
                return head;
            }
            fast = fast.next; // move fast to length - n th node
        }

        // if(fast == null){//if length == n
        //   //remove first node, so need a dummy node
        // }

        //linked list走的方法
        while (fast != null) {
            slow = slow.next;//slow starts from dummy
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }
}

class ListNode {
    public int value;
    public ListNode next;
    public ListNode(int value) {
        this.value = value;
        next = null;
    }
}