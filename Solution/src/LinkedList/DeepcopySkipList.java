package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class DeepcopySkipList {
    public SkipListNode copy(SkipListNode head) {
        // write your solution here
        Map<SkipListNode, SkipListNode> map = new HashMap<>();
        SkipListNode dummy = new SkipListNode(0);
        SkipListNode cur = dummy;

        //和copyrandom list是同样的流程，也是每次处理一个node
        while(head != null){
            if(!map.containsKey(head)){
                map.put(head, new SkipListNode(head.value));
            }

            cur.next = map.get(head);//link to copy list

            if(head.forward != null){
                if(!map.containsKey(head.forward)){
                    map.put(head.forward, new SkipListNode(head.forward.value));
                }
                cur.next.forward = map.get(head.forward);
            }

            head = head.next;
            cur = cur.next;
        }

        return dummy.next;
    }
}



  class SkipListNode {
    public int value;
    public SkipListNode next;
    public SkipListNode forward;
    public SkipListNode(int value) {
      this.value = value;
    }
  }