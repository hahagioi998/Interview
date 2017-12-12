package LinkedList.ReversalAndRotation;

/*
Hint: 这道题就不能用Dummy，一来没有用，处理后的head在尾部，二来处理不好还容易产生Cycle导致死循环。Invariant就是prev（包括它本身）之前的结点都是reverse完成的。

每次的执行操作是这样的：
开始状态：1->2->3
第一轮：prev=null,cur=1: null<-1 2->3
第二轮：prev=1, cur=2: null<-1<-2 3
第三轮：prev=2, cur=3: null<-1<-2<-3
结束：prev=3, cur=null

关于递归版本还动了些脑筋，reverseList()如果返回reverse后的头部，则与当前结点关联不上，如果返回尾部能关联上，但最后返回结果时又有问题。解决办法就是：依然返回reverse后的头部，但我们在递归调用之前先记住下一个结点，这样就相当于reverse后的头部和尾部都有了。
 */
public class ReverseLinkedList {
    public ListNode reverse(ListNode head) {
        //检查一下是否是只有一个node或者没有node
        if (head == null || head.next == null) {
            return head;
        }


        // prev->head => prev<=head, then move prev and cur off by one
        // invariant: nodes behind prev (inclusive) are reversed already

        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
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