package LinkedList.ReversalAndRotation;

//1->2->3->4->5
/*
92-ReversalAndRotation Linked List II (Medium): ReversalAndRotation a linked list from position m to n. Do it in-place and in one-pass.
For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,
return 1->4->3->2->5->NULL.
Note: Given m, n satisfy the following condition: 1 ≤ m ≤ n ≤ length of list.

一般有两种常用的方法来建立单链表：头插法与尾插法。

头插法从一个空表开始，读取数组a中的字符，生成新结点，将读取的数据存放到新结点的数据域中，然后将新结点插入到当前链表的表头上，直到结束为止。简单来说，就是把新加进的元素放在表头后的第一个位置：

1. 先让新节点的next指向头节点之后
2. 然后让表头的next指向新节点
比如学校食堂吃饭排了一大队人，你一上来就插到头一个，那么打饭师傅面对的NEXT就是你了，你的下一个就是原来的队头，队头的上一个就是你。

下面来分析这第二道题，因为要Reverse的不是整个链表了，用前面的方法会非常麻烦！因为reverse最终的头部在末尾，我们要记录好区间前后的start和end位置，等待reverse后才能将start、reverse的结点、end串联起来。而且如果reverse区间包含第一个或最后一个还要额外判断，简直麻烦得要死啊…… 这时就要采用所谓的“头插法”，它能保证每一时刻链表都处于正确的reverse状态，而不用等待最后。这样dummy头又能用了，会少了很多判断。

以[1,2,3,4],m=2,n=4为例，对比看一下它的执行过程：
开始状态：dummy->1->2->3->4
第一轮：prev=1, cur=2, then=3: dummy->1->3->2->4
第二轮：prev=1, cur=2, then=4: dummy->1->4->3->2
结束：prev=1, cur=2, then=null
会了“头插法”真是多了一样武器，来看这道题的扩展，一道Hard级别的题，在“头插法”面前黯然失色，变得非常简单直接。
 */
public class ReverseBetween {
    public ListNode reverseBetween2(ListNode head, int m, int n) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 1.Find node in front of range to be reversed
        //从dummy开始走，m-1就可以到m-1个node
        ListNode prev = dummy;
        for (int i = 0; i < m - 1; i++) {
            prev = prev.next;
        }

        // 2.Do the reversion
        // Invariant: prev->...->cur->then->... => prev->then...->cur->...
        // After that, "cur" stay the same, update "then
        //prev是不动的，用cur和then从最左开始两两反转，反转后的连到reverse
        ListNode cur = prev.next;
        for (int i = 0; i < n - m; i++) {
            ListNode then = cur.next;

            cur.next = then.next;
            //注意因为是头插法，这里不是cur，是先让新节点的next指向头节点之后
            then.next = prev.next;
            //把then插过去到prev后面
            prev.next = then;
        }
        return dummy.next;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m >= n || head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        for (int i = 1; i < m; i++) {//从dummy开始走, 1 to m就可以到前一个，0tom就刚好到m
            if (head == null) {
                return null;
            }
            head = head.next;
        }

        //做四个记录
        ListNode premNode = head;
        ListNode mNode = head.next;
        ListNode nNode = mNode, postnNode = mNode.next;


        //n-m次
        for (int i = m; i < n; i++) {
            if (postnNode == null) {
                return null;
            }

            ListNode temp = postnNode.next;
            postnNode.next = nNode;
            nNode = postnNode;
            postnNode = temp;
        }
        mNode.next = postnNode;
        premNode.next = nNode;

        return dummy.next;
    }
}
