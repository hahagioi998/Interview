package LinkedList.ReOrder;

/*
新建链表的好处就是不用考虑被移动结点的前继指向，因为最终原链表的所有结点都会被分类加入到新链表中，所以我们别忘了修改新链表中最后一个结点的指向就可以了。下面以第86题为例，来看一下这种方法，从代码上一眼就能看出这种方法的简洁。
 */
//L = 2 -> 4 -> 3 -> 5 -> 1 -> null, T = 3, is partitioned to 2 -> 1 -> 4 -> 3 -> 5 -> null
public class PartitionLL {
    public ListNode partition(ListNode head, int target) {
        // write your solution here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        ListNode curSmall = small;
        ListNode curLarge = large;

        while (head != null) {
            if (head.value < target) {
                curSmall = curSmall.next = head;
            } else {
                curLarge = curLarge.next = head;
            }
            head = head.next;
        }

        curSmall.next = large.next;
        // Note: don't worry about cycle, but remember this one!
        //head = null but not curLarge
        curLarge.next = null;
        return small.next;
    }

}
