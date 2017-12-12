package LinkedList;


public class MergeLL {

    public ListNode merge2(ListNode one, ListNode two) {
        // write your solution here
        if(one == null && two == null){
            return null;
        }
        //如果有一个是null
        if(one == null){
            return two;
        }else if(two == null){
            return one;
        }
        //需要一个新node
        ListNode dummy = new ListNode(0);
        ListNode newNode = dummy;

        while(one != null && two != null){//don't want one or two to stop at the last value
            if(one.value <= two.value){
                //链接
                newNode.next = one;
                one = one.next; //one and two don't move at the same time
            }else{
                newNode.next = two;
                two = two.next;
            }
            newNode = newNode.next;
        }

        if(one == null){
            newNode.next = two;
        }else{
            newNode.next = one;
        }

        return dummy.next;
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