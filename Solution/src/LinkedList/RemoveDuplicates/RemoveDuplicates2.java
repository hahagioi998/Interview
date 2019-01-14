package LinkedList.RemoveDuplicates;

//remove all duplicates, key is don't move cur unless there's no duplicates at all
/*
Hint: 因为要删除所有duplicate，而不是只保留一份，所以while循环里必须嵌套循环，发现duplicate就一删到底。
如果只用一层循环，那么效果就跟第83题一样了，必须保留一份duplicate，否则下一轮循环时不知道之前重复的是哪个结点。
因为都删了，所以还要保留重复的节点之前的点，不然不知道invariant是哪个
 */
//在leetcode上试一试，head != null && head.next != nul
public class RemoveDuplicates2 {
    public ListNode removeDup(ListNode head) {
        //left to cur including cur are not duplicates
        //only moving cur when there's no duplicates
        //only moving head when there are duplicates, and make head stop at last duplicates
        //so if there are no duplicates, cur.next == head, head is one step faster
        if(head == null || head.next == null){
            return head;
        }
        //可能会把头结点删掉
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        dummy.next = head;
        //head is fast
        while(head != null){
            //循环开始时cur和head都指向同一个
            //when there are duplicates
            //head != null && head.next != null(for duplicate at the end)
            //will make head stop at last duplicate element
            //这里和只保留一个是一样的，会保留最后一个重复的
            while( head != null && head.next != null && head.value == head.next.value){//look at the next head
                //这里面没有删，只是走到最后一个
                head = head.next;
            }
            //head didn't move, no duplicates，这里不是比较值，而是比较是不是同一个node
            //不能比较值，因为没有重复node的值也是相等
            if(cur.next == head){
                //only move cur when there's no duplicates
                cur = cur.next;
            }else{//when there are duplicates
                //not moving cur, but skip duplicates
                //把第一个重复也删掉
                cur.next = head.next;
            }
            head = head.next;

        }
        return dummy.next;
    }
}
