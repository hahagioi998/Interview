package binarytree.View;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

public class VerticalOrder {
    //we want to use preorder to maintain the order of insertion for arraylist, top gets insert first

    //treemap ganranteed average logn time put, remove
//    public static HashMap<Integer, ArrayList> ht = new HashMap<>();//hashmap doesn't maintain order of level
    public static TreeMap<Integer, ArrayList> ht = new TreeMap<>();
    public static int level;
    public ArrayList<Integer> al;

    public void vertical(Node root, int level) {
        if (root == null) {
            return;
        }
        //want to use level - 1 for left so left comes first in the treemap keyset
//        vertical(root.left, level + 1);//return from child's right

        if (ht.get(level) != null) {
            //有这一层了，把node加进去
            ArrayList x = ht.get(level);
            x.add(root.data);
            ht.put(level, x);
        } else {
            //还没有这一层，创建这一层，把node加进去
            al = new ArrayList<>();
            al.add(root.data);
            ht.put(level, al);
        }

        //topview的解法
//        if (!ht.containsKey(level)) {
//            // print it, its the first element at his level
//            //only put if it doesn't have the level
//            al = new ArrayList<>();
//            al.add(root.data);
//            ht.put(level, al);
//        }
        vertical(root.left, level - 1);

        vertical(root.right, level + 1);
    }

    public void printResult(TreeMap<Integer, ArrayList> ht) {
        Set<Integer> i = ht.keySet();//negative values come first
        System.out.println();
        for (int keys : i) {
            System.out.println(ht.get(keys));
        }
    }

    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        VerticalOrder p = new VerticalOrder();
        p.vertical(root, 0);
        p.printResult(ht);

    }
}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
        next = null;
    }
}