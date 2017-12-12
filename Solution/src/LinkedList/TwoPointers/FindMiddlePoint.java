package LinkedList.TwoPointers;

/*
这里有初始化slow和fast的方法，其实效果是一样的。一种是slow和fast都从head开始，另一个中是slow是head，fast在head.next
 */
public class FindMiddlePoint {
    public ListNode FindMiddlePoint(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode slow = head, fast = head.next;
//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        return slow;


        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head, fast = head;
        //2-3-4-5  4
        //2-3-4   3
        //we need both fast.next != null && fast.next.next != null because odd will result in npe
        //fast != null && fast.next != null 如果是1->2的话会返回1
        //fast.next != null && fast.next.next != null 如果是1->2的话会返回2
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //这个方法偶数的时后返回后一个1234返回3，用前面的方法返回2
    public ListNode findMiddle(ListNode head){
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void display(ListNode head) {
        ListNode currNode = head;
        while (currNode != null) {
            System.out.print("->" + currNode.value);
            currNode = currNode.next;
        }
    }

    public static void main(String[] args){
        FindMiddlePoint sol = new FindMiddlePoint();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(sol.FindMiddlePoint(head).value);
//        sol.display(head);
    }
}
