package LinkedList.SortLL;

public class QuickSortLL {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //找到中点
        ListNode mid = findMedian(head); // O(n)

        ListNode leftDummy = new ListNode(0), leftTail = leftDummy;
        ListNode rightDummy = new ListNode(0), rightTail = rightDummy;
        ListNode middleDummy = new ListNode(0), middleTail = middleDummy;

        //分成三条linked list，比mid小的，和mid一样的，比mid大的

        while (head != null) {
            if (head.value < mid.value) {
                leftTail.next = head;
                leftTail = head;
            } else if (head.value > mid.value) {
                rightTail.next = head;
                rightTail = head;
            } else {
                middleTail.next = head;
                middleTail = head;
            }
            head = head.next;
        }
        //断开
        leftTail.next = null;
        middleTail.next = null;
        rightTail.next = null;

        //再把左边和右边去sort
        ListNode left = sortList(leftDummy.next);
        ListNode right = sortList(rightDummy.next);

        //最后concat起来
        return concat(left, middleDummy.next, right);
    }

    private ListNode findMedian(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode concat(ListNode left, ListNode middle, ListNode right) {
        //要有一个新的开头
        ListNode dummy = new ListNode(0), tail = dummy;

        //左中右连起来
        tail.next = left; tail = getTail(tail);
        tail.next = middle; tail = getTail(tail);
        tail.next = right; tail = getTail(tail);
        return dummy.next;
    }

    //把head移到最后一位，返回head
    private ListNode getTail(ListNode head) {
        if (head == null) {
            return null;
        }

        while (head.next != null) {
            head = head.next;
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