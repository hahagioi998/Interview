package LinkedList.TwoPointers;
//第142题Linked List Cycle II则更进一步，变成了数学推导问题…… 所以我干脆把它放到数学分类去了……
public class CheckCycleII {
    public ListNode cycleNode(ListNode head) {
        // write your solution here
        //distance travelled by slow  x+y
        //distance travelled by fast (x+y+z) +y
        //time is constant, and fast has double speed
        //2(x+y) = x+y+z+y => x= z
        if(head == null || head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                slow = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
        }
        return null;
    }
}
