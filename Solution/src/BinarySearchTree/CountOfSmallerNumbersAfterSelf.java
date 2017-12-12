package BinarySearchTree;

import java.util.Arrays;
import java.util.List;
/*
Given nums = [5, 2, 6, 1] 因为是看更小的，所有在BST是向自己左边看，insert的话就是1，6，2，5
The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
Return the array [2, 1, 1, 0].

contruct a BST using the nums
Every node will maintain a val sum recording the total of number on it's left bottom side, dup counts the duplication.
For example, [5，3，2，2，6，1], we want to return [4，3，1，1，1，0], we would have:

                1(0, 1)
                     \
                     6(3, 1)
                     /
                   2(0, 2)
                       \
                        3(0, 1)
When we try to insert a number, the total number of smaller number would be adding dup and sum of the nodes where we turn right.
for example, if we insert 5, it should be inserted on the way down to the right of 3, the nodes where we turn right is 1(0,1), 2,(0,2), 3(0,1), so the answer should be (0 + 1)+(0 + 2)+ (0 + 1) = 4

if we insert 7, the right-turning nodes are 1(0,1), 6(3,1), so answer should be (0 + 1) + (3 + 1) = 5
 */
public class CountOfSmallerNumbersAfterSelf {
    //用一个新的node class来做记录
    class Node {
        Node left, right;
        //值，sum是自己的左子树值的个数，值的个数最小是1
        int val, sum, dup = 1;
        public Node(int v, int s) {
            val = v;
            sum = s;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        Integer[] ans = new Integer[nums.length];

        Node root = null;
        //倒着一个一个加，一边加一边做一个BST
        for (int i = nums.length - 1; i >= 0; i--) {
            //每次root最后返回的都是BST的根，比如1
            //presum每次都0
            root = insert(nums[i], root, ans, i, 0);
        }
        return Arrays.asList(ans);
    }

    //num是当前要加的值，node是上一个加的node，ans是答案array，i是index，presum是累计所有比当前值小的值 = dup and sum of the nodes where we 往右走
    private Node insert(int num, Node node, Integer[] ans, int i, int preSum) {
        if (node == null) {
            //初始，没有根，sum是看自己左子树的个数，这个时候也没有就是0，最后返回新创建的node
            //recursion的base case
            node = new Node(num, 0);
            ans[i] = preSum;
        } else if (node.val == num) {
            //和自己的根是重复，不创建新的node
            //2和2是重复，改变了2的dup
            node.dup++;
            ans[i] = preSum + node.sum;
        } else if (node.val > num) {
            //要加的值比根小，在这个更改根的sum
            //比如2比6小，2在6左边，6的sum就要增加，presum是1，因为走了1的右边
            node.sum++;
            node.left = insert(num, node.left, ans, i, preSum);
        } else {
            //只有要加的值比根大的时候，才更新presum
            //比如6比1大，往1的右边加，presum就是1的个数+比1小的值的个数+自己的presum 0
            node.right = insert(num, node.right, ans, i, preSum + node.dup + node.sum);
        }
        return node;
    }

    public static void main(String[] args){
        CountOfSmallerNumbersAfterSelf sol = new CountOfSmallerNumbersAfterSelf();
        int[] array = new int[]{5,3,2,2,6,1};
        sol.countSmaller(array);
    }
}
