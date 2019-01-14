package LinkedList.TwoPointers;
/*
I found most solutions here preprocess linkedlists to get the difference in len.
Actually we don't care about the "value" of difference, we just want to make sure two pointers reach the intersection node at the same time.

We can use two iterations to do that. In the first iteration, we will reset the pointer of one linkedlist to the head of another linkedlist after it reaches the tail node. In the second iteration, we will move two pointers until they points to the same node. Our operations in first iteration will help us counteract the difference. So if two linkedlist intersects, the meeting point in second iteration must be the intersection point. If the two linked lists have no intersection at all, then the meeting pointer in second iteration must be the tail node of both lists, which is null

 Hint: 一开始想得有些复杂了，想把A形成个环，然后将这道题转化成找Cycle起点的那道题。其实通过两个链表的长度差，通过两个指针就能找到这个Intersection的位置。有点像第61题将在第k个位置旋转链表，于是让一个指针先出发，另一个指针等待k个操作后再出发。还有种非常聪明的做法是：两个指针在两个链表上同时遍历，当到达末尾时就交换到另一个链表上继续遍历，当后一个指针发生交换后，两者就处于相同的位置了，可以一起继续遍历找相同结点了。代码非常简单，数学之美，非常聪明！
 */
public class IntersectionOfTwoLL {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //boundary check
        if(headA == null || headB == null) {
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        //如果a不是null，就一直让a向后走，走到null的时候转成B
        // lenb-lena = 2  a到结尾的时候，b在倒数第2，b到结尾的时候，a就是b的正数第2，b再到a的开头就一样长了
        //  7 1 2 3 4
        //4 5 6
        while( a != b ){
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }

        return a;
    }
}
