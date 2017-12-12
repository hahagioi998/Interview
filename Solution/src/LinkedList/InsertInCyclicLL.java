package LinkedList;

//Given a list, and insert a value 4:
//        3->5->1
//        Return 5->1->3->4
public class InsertInCyclicLL {
    public ListNode insert(ListNode node, int x) {
        // 如果是node是null，就创建一个node，制造成一个环
        if (node == null) {
            node = new ListNode(x);
            node.next = node;
            return node;
        }

        ListNode p = node;
        ListNode prev = null;
        do {
            prev = p;
            p = p.next;
            if (x <= p.value && x >= prev.value) {
                break;
            }
            if ((prev.value > p.value) && (x < p.value || x > prev.value)) {
                break;
            }
        } while (p != node);

        ListNode newNode = new ListNode(x);
        newNode.next = p;
        prev.next = newNode;
        return newNode;
    }
}
