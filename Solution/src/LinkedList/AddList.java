package LinkedList;


//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//        Output: 7 -> 0 -> 8class Solution(object):
public class AddList {
    public ListNode addLists(ListNode l1, ListNode l2) {
        //两个list都！
            if(l1 == null && l2 == null) {
                return null;
            }

            ListNode head = new ListNode(0);
            ListNode point = head;
            int carry = 0;
            while(l1 != null && l2!=null){
                int sum = carry + l1.value + l2.value;
                point.next = new ListNode(sum % 10);
                carry = sum / 10;

                //有三个指针要移动
                l1 = l1.next;
                l2 = l2.next;
                point = point.next;

            }

            while(l1 != null) {
                int sum =  carry + l1.value;
                point.next = new ListNode(sum % 10);
                carry = sum /10;
                //两个指针要移动
                l1 = l1.next;
                point = point.next;
            }

            while(l2 != null) {
                int sum =  carry + l2.value;
                point.next = new ListNode(sum % 10);
                carry = sum /10;
                l2 = l2.next;
                point = point.next;
            }

            if (carry != 0) {
                point.next = new ListNode(carry);
            }
            return head.next;
        }
        /* 扫描一次的方法
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        int carry = 0;
        // i != null || j != null; 有一个不是null就行
        for (ListNode i = l1, j = l2; i != null || j != null; ) {
        //处理sum的时候，如果是null了就加0
            int sum = carry;
            sum += (i != null) ? i.value : 0;
            sum += (j != null) ? j.value : 0;

            tail.next = new ListNode(sum % 10);
            tail = tail.next;

            carry = sum / 10;
            //如果是null了就还是等于null就好
            i = (i == null) ? i : i.next;
            j = (j == null) ? j : j.next;
        }

        if (carry != 0) {
            tail.next = new ListNode(carry);
        }
        return dummy.next;
        */

}
