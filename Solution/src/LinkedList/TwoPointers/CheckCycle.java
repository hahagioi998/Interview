package LinkedList.TwoPointers;

/*
Hint: 代码很简单，关键是：思路太巧妙，实在想不到…… 感觉两个指针像是两个运动员在赛跑，两个“人”最终肯定会进入Cycle，并且快的一个最终将”套圈儿“追上慢的。
第142题Linked List Cycle II则更进一步，变成了数学推导问题…… 所以我干脆把它放到数学分类去了……
 */
public class CheckCycle {
    public boolean hasCycle(ListNode head) {
    if (head == null) return false;

    ListNode slow = head, fast = slow;

    while (fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) {
            return true;
        }
    }
    return false;
    }
}
