package binarytree.Reconstruct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LevelorderAndInorder {
    public TreeNode reconstruct(int[] level, int[] in){
        HashMap<Integer, Integer> inMap = new HashMap<Integer,Integer>();
        for (int i=0;i< in.length;++i) {
            inMap.put(in[i], i);
        }

        //把level里的数字都放到list里
        List<Integer> lList = new ArrayList<>();
        for(int num : level){
            lList.add(num);
        }

        return helper(inMap, lList);
    }

    private TreeNode helper(HashMap<Integer, Integer> inMap, List<Integer> level){
        //arraylist被拿空
        if(level.isEmpty()){
            return null;
        }

        TreeNode root = new TreeNode(level.remove(0));
        //不断分左边和右边的level
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        //要遍历整个level
        //利用inorder来划分左边和右边的范围，root在inorder里面的index一定大于它左边的
        for(int num : level){
            if (inMap.get(num) < inMap.get(root.key)) {
                left.add(num);
            }else{
                right.add(num);
            }
        }

        root.left = helper(inMap, left);
        root.right = helper(inMap, right);
        return root;
    }
}
