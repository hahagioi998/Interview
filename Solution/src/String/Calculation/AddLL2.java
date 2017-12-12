package String.Calculation;

import java.util.Stack;

//public class AddLL2 {
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        //用了两个stack
//        StackQueue<Integer> s1 = new StackQueue<Integer>();
//        StackQueue<Integer> s2 = new StackQueue<Integer>();
//
//        while(l1 != null) {
//            s1.push(l1.val);
//            l1 = l1.next;
//        };
//
//        while(l2 != null) {
//            s2.push(l2.val);
//            l2 = l2.next;
//        }
//
//        int sum = 0;
            //尾巴
//        ListNode list = new ListNode(0);
//        while (!s1.empty() || !s2.empty()) {
//            if (!s1.empty()) sum += s1.pop();
//            if (!s2.empty()) sum += s2.pop();
//            list.val = sum % 10;
                //head 是list的前一个，这样才能连出一个正的来
//            ListNode head = new ListNode(sum / 10);
//            head.next = list;
//            list = head;
//            sum /= 10;
//        }
//
//        return list.val == 0 ? list.next : list;
//    }
//}
