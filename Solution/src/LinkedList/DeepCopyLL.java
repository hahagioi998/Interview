package LinkedList;

import java.util.HashMap;

public class DeepCopyLL {
    public RandomListNode copy(RandomListNode head) {
        // Write your solution here.
        if(head == null){
            return null;
        }
        //新的list开头
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode cur = dummy;
        //map contains nodes in original list as key, the copy of original node as value
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();

        //random和next一起做的，每次创建一个node
        while(head != null){
            //没有node就要添加
            if(!map.containsKey(head)){
                map.put(head, new RandomListNode(head.value));
            }

            //连到新创建的node，只能通过get（head）
            cur.next = map.get(head);
            //如果有random node的话
            if(head.random != null){
                //查是否已经加入map
                if(!map.containsKey(head.random)){
                    map.put(head.random, new RandomListNode(head.random.value));
                }

                cur.next.random = map.get(head.random);
            }

            head = head.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}


  class RandomListNode {
    public int value;
    public RandomListNode next;
    public RandomListNode random;
    public RandomListNode(int value) {
      this.value = value;
    }
  }
