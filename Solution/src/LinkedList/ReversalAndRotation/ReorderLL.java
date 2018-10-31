package LinkedList.ReversalAndRotation;

import java.util.List;

/*
如果说其他题是为了reverse而reverse的话，那么有两个题可以说是reverse的真实应用。
143题要将链表Reorder成L1->Ln->L2->Ln-1->…这种顺序，而第234题则是判断Palindrome，即L1=Ln，L2=Ln-1…。可以看出这两道题非常相似，想顺序做是不可能的，因为它们都需要从Ln到Ln-1不断向前遍历。
所以将链表的后半部分reverse之后，再进行插入或比较就可以了。

Hint: 首先要找到中点，将前后两部分想办法合并成题目要求的顺序。尝试了一下直接合并，没有找到规律。
于是还是老老实实地将后半部分Reverse之后再合并吧。关于找中点也有技巧，不需要遍历到末尾记住总个数，然后再来一遍找到中点。
而是类似于141-Linked List Cycle那样，用快慢两个指针同时遍历，停下来时慢指针指的就是中点，巧妙吧！
关于Corner Case就是链表只有1个或2个结点的情况，导致快慢指针没出发就停止了。
Reverse后半部分时如果连着前半部分则容易糊涂，直接一刀切断就行了，这样后面合并时也比较清楚！
 */
// 1->n->2->n-1->3 ->n-2
public class ReorderLL {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        // 1.Find middle node
        ListNode mid = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            mid = mid.next;
            fast = fast.next.next;
        }

        // 2.Reverse second half
        ListNode prev = mid, cur = prev.next;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        //断开
        mid.next = null;

        // 3.Merge two halves: p1 and p2 moves on two halves by turns
        // why only check p1... 因为p1不是null，那p1.next就不会npe
        //p1比较短
        for (ListNode p1 = head, p2 = prev; p1 != null; ) {
            //一般要记下断开的那个点，会丢掉的开头
            ListNode tmp = p1.next;
            //p1.next = p2; p1 = p1.next;
            p1 = p1.next = p2;
            p2 = tmp;
        }
    }


    public ListNode reorder(ListNode head) {
        // find middle, reverse, merge
        if(head == null || head.next == null){
            return head;
        }
        ListNode middle = findMiddle(head);
        ListNode secondHalf = middle.next;
        middle.next = null;//delink the first half before reverse, middle is in the first half
        ListNode reversedNode = reverse(secondHalf);

        return merge(head, reversedNode);
    }

    public ListNode findMiddle(ListNode node){
        ListNode slow = node;
        ListNode fast = node;
        while(fast.next != null && fast.next.next != null){//fast!= null 3 elements fast.next 2elements
            slow = slow.next;//slow = node.next;
            fast = fast.next.next;//fast = node.next.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode node){
        if(node == null || node.next == null){//for short linked list
            return node;
        }
        ListNode pre = null;
        while(node != null){
            ListNode temp = node.next;
            node.next = pre;
            pre = node;
            node = temp;
        }
        return pre;//node = null
    }

    public ListNode merge(ListNode n1, ListNode n2){
        //need dummy node because don't know which one is longer
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;//use cur to traverse and link
        while(n1!= null && n2!= null){//want to determine which one is larger, don't use .next != null
            cur.next = n1;
            n1 = n1.next;
            cur.next.next = n2;
            n2 = n2.next;
            cur = cur.next.next;
        }
        if(n1 != null){
            cur.next = n1;
        }else{
            cur.next = n2;
        }
        return dummy.next;
    }

    public void display(ListNode head) {
        ListNode currNode = head;
        while (currNode != null) {
            System.out.print("->" + currNode.value);
            currNode = currNode.next;
        }
    }

    public static void main(String[] args){
        ReorderLL sol = new ReorderLL();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        sol.reorderList(head);
        sol.display(head);
    }
}
