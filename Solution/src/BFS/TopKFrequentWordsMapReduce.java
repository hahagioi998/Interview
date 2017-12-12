package BFS;

import java.util.*;

/*
使用map reduce框架查找最常使用的k个单词.
mapper的key为文档的id, 值是文档的内容, 文档中的单词由空格分割.
对于reducer，应该输出最多为k个key-value对, 包括最常用的k个单词以及他们在当前reducer中的使用频率.评判系统会合并不同的reducer中的结果以得到 全局 最常使用的k个单词, 所以你不需要关注这一环节. k 在TopK类的构造器中给出.
 */
public class TopKFrequentWordsMapReduce {
    private Map<String, Integer> words = null;
    //extends sorted set
    private NavigableSet<String> topk = null;
    private int k;

    private Comparator<String> myComparator = new Comparator<String>() {
        public int compare(String left, String right) {
            //same string
            if (left.equals(right))
                return 0;
            //get count
            int left_count = words.get(left);
            int right_count = words.get(right);
            if (left_count != right_count) {
                return right_count - left_count;
            }
            //same count
            return left.compareTo(right);
        }
    };

    public TopKFrequentWordsMapReduce(int k) {
        // initialize your data structure here
        this.k = k;
        words = new HashMap<>();
        //pass comparator to it
        topk = new TreeSet<>(myComparator);
    }

    public void add(String word) {
        // Write your code here
        if (words.containsKey(word)) {
            if (topk.contains(word))
                //remove because count is updated for this word
                topk.remove(word);
            words.put(word, words.get(word) + 1);
        } else {
            words.put(word, 1);
        }

        //add word
        topk.add(word);
        if (topk.size() > k) {
            //last has smaller frequency
            topk.pollLast();
        }
    }

    public List<String> topk() {
        // Write your code here
        List<String> results = new ArrayList<String>();
        Iterator it = topk.iterator();
        while(it.hasNext()) {
            String str = (String)it.next();
            results.add(str);
        }
        return results;
    }

    public static void main(String[] args){
        TopKFrequentWordsMapReduce sol = new TopKFrequentWordsMapReduce(2);
        sol.add("no has no body but given no chance has");
        List<String> res = sol.topk();
                System.out.println(res);
    }
}
