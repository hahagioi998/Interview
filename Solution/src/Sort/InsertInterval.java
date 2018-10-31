package Sort;

import java.util.ArrayList;
import java.util.List;

//Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
//Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
//有交集的话有三种情况，和前一个相交，和后一个相交，和前后相交；还有不想交;还有包含
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (newInterval == null || intervals == null) {
            return intervals;
        }

        List<Interval> results = new ArrayList<>();
        int insertPos = 0;

        for (Interval interval : intervals) {
            if (interval.end < newInterval.start) {
                //不想交也不包含,在newInterval的前面
                results.add(interval);
                //确定insert position，在这里确认是因为新的interval要么就是在index 0，要么前面必然有别的interval
                insertPos++;
            } else if (interval.start > newInterval.end) {
                //不想交也不包含,在newInterval的后面
                results.add(interval);
            } else {
                //相交或包含，改变newInterval的数据，这样可以和下一个interval比较
                //interval.end >= newInterval.start
                //interval.start <= newInterval.end
                newInterval.start = Math.min(interval.start, newInterval.start);
                newInterval.end = Math.max(interval.end, newInterval.end);
            }
        }
        //在适当的位置插入newInterval
        results.add(insertPos, newInterval);

        return results;
    }
}
