package LinkedList.ReOrder;
/*
Hint: 数组版本的插入排序会不断向前比较，找到合适位置后右移其他大于当前的数据，然后再处理下一个。而链表版本则有两点不同：一是单向链表没法向前比较，所以变通一下，我们每次都从头往后比较，找到大于当前结点值的位置；其二是把当前结点插入到那个位置的操作可以说是普通插入的复杂版本，因为插入的元素本身也有前后结点连接着。所以，遍历当前结点的指针和前面找位置的指针都必须是前一个结点（prev），否则会产生Cycle导致死循环。还有个有趣的现象是，当把插入完成后，当前结点无需移动，因为后面的元素在一点点减少，循环会自己中止的。但注意如果当前结点在前半部分已是最大，无需移动时，这时需要手动移动当前指针以防死循环。
 */
public class InsertionSortLL {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode cur = head;
        while (cur.next != null) {
            // Find where to insert cur.next, or stop at cur
            ListNode pos = dummy;
            while (pos.next.value < cur.next.value) {
                pos = pos.next;
            }
            //  pos(a),pos.next(b),...cur(c),cur.next(d),cur.next.next(e)
            //  => a,d,b,...,c,e
            if (pos != cur) {
                ListNode tmp = pos.next;
                pos.next = cur.next;
                cur.next = cur.next.next;
                pos.next.next = tmp;
            } else {
                cur = cur.next; // error1: cur.next is updated already above, but it must update here!
            }
        }
        return dummy.next;
    }
}
