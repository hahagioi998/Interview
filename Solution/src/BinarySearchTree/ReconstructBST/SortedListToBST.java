package BinarySearchTree.ReconstructBST;
/*
Say mid is the mid­dle node in the linked list.
        Recur­sively con­struct left sub­tree from start to mid-1
        Make the mid­dle node as root and assign the left sub­tree to it.
        Recur­sively con­struct right sub­tree from mid+1 to end.
        Assign the right sub­tree to root.
        */
//用inorder traversal
public class SortedListToBST {
    //current node就是global的
    private ListNode current;

    private int getListLength(ListNode head) {
        int size = 0;

        while (head != null) {
            size++;
            head = head.next;
        }

        return size;
    }

    public TreeNode sortedListToBST(ListNode head) {
        int size;

        //最开始的node是head
        current = head;
        //要知道这个list有多长
        size = getListLength(head);

        return sortedListToBSTHelper(size);
    }

    public TreeNode sortedListToBSTHelper(int size) {
        //size为0不再有什么意义
        if (size <= 0) {
            return null;
        }

        //进行inorder traversal！
        TreeNode left = sortedListToBSTHelper(size / 2);

        TreeNode root = new TreeNode(current.value);
        current = current.next;

        TreeNode right = sortedListToBSTHelper(size - 1 - size / 2);//减掉中间的root

        root.left = left;
        root.right = right;

        //返回root
        return root;
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode tail = new ListNode(6);
        head.next.next.next.next.next = tail;

        SortedListToBST i = new SortedListToBST();
        TreeNode x = i.sortedListToBST(head) ;
        System.out.print("Constructed BST is :");
        i.inorder(x);

    }

    public void inorder(TreeNode root){
        if(root!=null){
            inorder(root.left);
            System.out.print(" " + root.key);
            inorder(root.right);
        }
    }
}

class TreeNode {
    int key;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.key = data;
        left = null;
        right = null;
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