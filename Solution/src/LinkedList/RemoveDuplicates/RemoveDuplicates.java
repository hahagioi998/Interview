package LinkedList.RemoveDuplicates;


//appear only onece
public class RemoveDuplicates {
    /*
    Hint: 从这道题我们可以学习一下删除结点的两种方法，可以说各种所长。
    第一种是向后比较结点，发现重复就删掉。因为可能会删掉后面的结点，所以一定要注意cur的判空条件。当正常遍历时，cur可能为空，当删掉了后面结点时cur.next可能为空，都要判断。
    第二种是向前比较结点，即用prev记录前一个结点的值，发现相同就删掉当前结点，判空条件简单一些，但一定注意prev和cur的更新。因为这道题肯定不会删除head，所以也就没用到dummy头结点。
     */
    public ListNode removeDup(ListNode head) {
        //Input your code here
        if(head == null || head.next == null){
            return head;
        }
        // Version-1: Compare cur and cur.next without prev
        // Note both cur and cur.next could reach null

            ListNode cur = head;
            while (cur != null && cur.next != null) {
                if (cur.value == cur.next.value) {
                    cur.next = cur.next.next;
                } else {
                    cur = cur.next;
                }
            }
            return head;
    }

    // Version-2: compare cur and prev
    // Note update of prev and cur
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) {
            return null;
        }

        // Invariant: node prior to prev (inclusive) has no duplicates
        ListNode cur = head.next, prev = head;
        while (cur != null) {
            if (cur.value == prev.value) {
                //这里prev要移动是为了变成新的值，这样cur就可以和新的prev进行比较
                prev.next = cur.next;
                cur = prev.next;
            } else {
                //这里prev要移动是为了变成新的值，这样cur就可以和新的prev进行比较
                prev = cur;
                cur = cur.next;
            }
        }
        return head;
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