package LinkedList.TwoPointers;

/*
Hint: 务必注意！k指的不是旋转的Pivot位置，而是向右k个位置，也就是说k可能远大于链表长度！此外，实现旋转时我写的比较麻烦了，用两个指针相隔k（已经对长度len取余）一起往后跑直到快的指针到达末尾，再开始旋转。
而技巧是：利用前面已经跑到链表末尾的指针，将链表首尾相连形成个环，然后继续跑len-k个位置再断开就可以了，比较巧妙！
 */
public class RotateListByk {
    //最精简
    public ListNode rotateRight2(ListNode head, int n) {
        if (head==null||head.next==null) return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        //都从dummy开始，fast跑k次就会刚好跑到第k个node
        ListNode fast=dummy,slow=dummy;

        int i;
        for (i=0; fast.next!=null;i++)//Get the total length
            fast=fast.next;

        //这个时候i就是length了
        //再跑len-k个node
        for (int j=i-n%i; j>0; j--) //Get the i-n%i th node
            slow=slow.next;

        fast.next=dummy.next; //Do the rotation
        dummy.next=slow.next;
        slow.next=null;

        return dummy.next;
    }

    public ListNode rotateKplace(ListNode head, int k) {
        //Input your code here
        if(head == null){
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = head;
        ListNode slow = head;

        int length = 0;
        //要先找到长度
        while(head != null){
            head = head.next;
            length++;
        }

        //k可能会大于链表的长度，不论fast从哪开始，这时fast跑了k次，到了从f开始的位置是第1个node算起第k+1个node，f从dummy开始第k个node
        //index的话从开始的位置是0跑到到k差是k，中间隔着k-1个node
        // 1f 2 3 4 k = 3
        // 1 2f 3 4 k= 2
        // 1 2 3f 4 k = 1
        // 1 2 3 4f k = 0  3个loop
         while((k % length) > 0){
            fast = fast.next;
            k--;
        }

        //fast不是走到null，而是走到最后一个，如果是走到null，那slow就会在k nth nodefrom end
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        //fast是跑到链表末尾的指针
        fast.next = dummy.next;// 1->2  turn into a cycle 1->2->1->2
        dummy.next = slow.next;
        //别忘了切断
        slow.next = null;//cut the cycle

        return dummy.next;
    }

    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length ++;
            head = head.next;
        }
        return length;
    }

    public ListNode rotateRight(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        int length = getLength(head);
        n = n % length;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        ListNode tail = dummy;
        for (int i = 0; i < n; i++) {
            head = head.next;
        }

        while (head.next != null) {
            tail = tail.next;
            head = head.next;
        }

        head.next = dummy.next;
        dummy.next = tail.next;
        tail.next = null;
        return dummy.next;
    }
}
