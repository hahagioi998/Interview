package LinkedList;


public class InsertInLL {
    public ListNode insert(ListNode head, int value) {
        // could be done using one pointer traverse through whole list
        // the insertion position is between prev and pre.next
        //或者可以用dummy node可以让所有的节点统一地处理。
        ListNode newNode = new ListNode(value);
        //只有一个node的情况
        if (head == null || head.value >= value) {
            newNode.next = head;
            return newNode;
        }
        //需要prev
        ListNode prev = head;
        //停在最后一个node
        while (prev.next != null && prev.next.value < value) {
            prev = prev.next;
        }//break out of the loop when next node value > value, or end of list

        //头插法
        newNode.next = prev.next;
        prev.next = newNode;

        return head;
    }
}
