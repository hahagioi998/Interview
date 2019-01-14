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
        //fast != null && fast.next != null 如果是1->2的话会返回2，fast是null
        //fast.next != null && fast.next.next != null 如果是1->2的话会返回1，fast也在1
        // 12345 两个方法都会返回3
      //12345678 slow是4，fast是7，slow的index*2
      //123456789 slow是5，fast是9
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //fast是正好是slow index*2，所以偶数个的时候就会是null了
    //这个方法偶数的时后返回后一个1234返回3，fast是null，用前面的方法返回2
    //123456789的话，slow是5，fast是9
  //两种方法奇书的时候结果是一样的，偶数个的时候不一样
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
        ListNode cur = head;
        for(int i = 2; i < 10; i++) {
          cur.next = new ListNode(i);
          cur = cur.next;
        }

        System.out.println(sol.FindMiddlePoint(head).value);
//        sol.display(head);
    }
}
