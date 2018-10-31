package BinarySearchTree;
//Given Preorder traversal of a BST
/*
找到规律
Examples

Input: pre[] = {20, 10, 11, 13, 12}
Output: Yes
The give array represents following BST. In the following BST, every internal
node has exactly 1 child. Therefor, the output is true.
        20
       /
      10
       \
        11
          \
           13
           /
         12
         In Preorder traversal, descendants (or Preorder successors) of every node appear after the node. In the above example, 20 is the first node in preorder and all descendants of 20 appear after it. All descendants of 20 are smaller than it. For 10, all descendants are greater than it. In general, we can say, if all internal nodes have only one child in a BST, then all the descendants of every node are either smaller or larger than the node. The reason is simple, since the tree is BST and every node has only one child, all descendants of a node will either be on left side or right side, means all descendants will either be smaller or greater.
 */
/*
1. Scan the last two nodes of preorder & mark them as min & max.
2. Scan every node down the preorder array. Each node must be either smaller than the min node or larger than the max node. Update min & max accordingly.
 */
public class CheckInternalNodeBSTWithOneChild {
    public boolean isBST(int input[]){
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;

        //到input.length-1为止，因为用了input[i+1]
        for(int i = 0; i < input.length-1; i++){
            //一定是在这个范围之间
            if(input[i] > min && input[i] < max){
                //下一个值
                if(input[i+1] < input[i]){
                    max = input[i];
                }else{
                    min = input[i];
                }
            }else{
                return false;
            }
        }
        //post process看是否是在这个范围之间
        if(input[input.length-1] < max && input[input.length-1] > min){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String args[]){
        int input[] = {20,10,14,15,17};
        CheckInternalNodeBSTWithOneChild boc = new CheckInternalNodeBSTWithOneChild();
        System.out.println(boc.isBST(input));
    }
}
