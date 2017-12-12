package binarytree.LCA;

public class lca2 {
    public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
    // linked list is a special kind of tree
    int l1 = length(one);
    int l2 = length(two);
    if(l1 <= l2){//longer one is deeper down the tree
        return mergeNode(one, two, l2 - l1);
    }else{
        return mergeNode(two, one, l1 - l2);
    }
}

    private TreeNodeP mergeNode(TreeNodeP shorter, TreeNodeP longer, int diff){
        while(diff > 0){//bring longer and shorter to the same level
            longer = longer.parent;
            diff--;
        }
        while(longer != shorter){//go up until short and longer meet
            //if one of them is null, loop will break when longer one become null
            longer = longer.parent;
            shorter = shorter.parent;
        }
        return longer;
    }

    private int length(TreeNodeP node){
        int length = 0;
        while(node != null){//go up
            length++;
            node = node.parent;
        }
        return length;
    }
}


  class TreeNodeP {
    public int key;
    public TreeNodeP left;
    public TreeNodeP right;
    public TreeNodeP parent;
    public TreeNodeP(int key, TreeNodeP parent) {
      this.key = key;
      this.parent = parent;
    }
  }

