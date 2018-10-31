package LinkedList.ReversalAndRotation;
/*
Hint: 简单解法很容易，遍历链表时用一个ArrayList存所有值，然后检查ArrayList就行了。注意：ArrayList里的是Integer，判断相等要用equals而不能用==！O(1)空间做法与第143题非常像！就是用快慢指针找到链表中点后，反转后半链表，然后从前后两个方向模仿数组那样检查Palindrome。注意：终止条件是right!=mid或left、right都不为空，如果只检查left!=right的话会空指针或死循环！同时关于reverse，不能用“头插法”，因为我们要在reverse完成后从后往前做比较，“头插法”是不合适的！
 */

public class CheckPalindrome {
    public boolean isPalindrome(ListNode head) {
        // 1234返回3，reverse 3和4
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //用两种方法奇数的时候 fast都是最后一个值，slow是中间值
      //偶数的话slow就是3了
        if(fast != null){
            slow = slow.next;
        }

        ListNode secondHalf = reverse(slow);

        //要让secondHalf比较短才行
        while(secondHalf != null){// no of fisthalf and secondhalf are equal
            if(head.value != secondHalf.value){
                return false;
            }
            head = head.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head != null){
            //从head这里断开
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }

        return prev;
    }
}
