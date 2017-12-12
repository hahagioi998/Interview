package LinkedList.ReOrder;


import java.util.List;

/*
Input List:  1->2->3->4->5->6
Output List: 1->3->5->6->4->2

Input List:  12->14->16->18->20
Output List: 12->16->20->18->14
put odd before even，even是反着的
Hint: 这种不是删除结点而是移动重新插入结点的问题要注意：prev/cur等游标指针的移动，是不是后面结点被移走了就不用移动了，是不是后面结点移走了就null了等等。
 */
public class ReverseAlternateNodes {

    public ListNode addAtFront(ListNode node, ListNode head){
        if(head == null){
            return node;
        }
        node.next = head;
        return node;
    }

    public ListNode act(ListNode head){
        if(head == null || head.next == null || head.next.next == null){
            return head;
        }

        ListNode result = null;
        ListNode odd = head;

        //考虑奇偶数的问题
        while(odd != null && odd.next != null){

            ListNode even = odd.next;

            odd.next = odd.next.next;
            //断开当前的even点
            even.next = null;
            //result就是反过来的第一个，一个一个把even反着加上去
            result = addAtFront(even, result);

            if(odd.next == null){
                break;
            }
            odd = odd.next;
        }
        odd.next = result;
        return head;
    }

    public ListNode reverseAlternate(ListNode head) {
        // reverse even lists
        //need to know where the even starts
        // If linked list has fewer than 3 nodes, no change is required
        if(head == null || head.next == null || head.next.next == null){
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next; //last even node
        // ListNode prev = null; even will become prev

        //跳过了一个
        head.next = head.next.next;
        //if there are only two nodes, then head will become null
        head = head.next;//3

        //break linkage when done with head.next
        even.next = null;

        while(head != null && head.next != null){//even and odd no of nodes
            ListNode tmp = head.next.next;//head.next != null but head.next.next could be null
            //head.next is the next even node，向前连
            head.next.next = even;
            even = head.next;

            //跳过even node
            head.next = tmp;

            if(tmp != null){
                head = tmp;//tmp could be null
            }
        }
        head.next = even;
        return odd;
    }

    //感觉可以直接把even设成null，测试一下
}

class ListNode {
    public int value;
    public ListNode next;
    public ListNode(int value) {
        this.value = value;
        next = null;
    }
}