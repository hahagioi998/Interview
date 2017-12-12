package Sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//first count all frequencies of elements

public class TopKElement {
    public List<Integer> topKFrequent(int[] nums, int k) {

        //bucket是array of list of intergers！！！！bucket的index是频率，里面存的值是出现过这个频率的数字
        //bucket是nums.length + 1长
        //因为最多的frequency就是length个
        List<Integer>[] bucket = new List[nums.length + 1];
        //integer and its frequency
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        //put the value 里去get
        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        //从keyset中拿出integer和integer出现的频次
        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);

            //给每个bucket创建一个arraylist
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            //在每个frequency对应的bucket里加入数字
            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();

        //从bucket从后向前找，后面一定是频率高的
        //res.size() < k
        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            //如果不是空着的就把所有那个频率出现的数字加到结果里 addAll
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        return res;
    }
}
