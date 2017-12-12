package Sort;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//你可以做的就是遍历整个list，然后比较
//可以改变array
class Interval {
    int start, end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
public class MergeIntervalI {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }

        Collections.sort(intervals, new IntervalComparator());

        List<Interval> result = new ArrayList<Interval>();
        //指向第一个
        Interval last = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            //指向当前的
            Interval curt = intervals.get(i);
            //上一个的后面和当前的开头比,当前的开头是不会比上一个的开头更小的[1,2][3,5]
            if (curt.start <= last.end ){//<=
                //相交或者包含，改变指向的上一个的end
                last.end = Math.max(last.end, curt.end);
            }else{
            //只有在没有相交或者包含的时候加上一个
                result.add(last);
                //last变成cur
                last = curt;
            }
        }
        //最后一个
        result.add(last);
        return result;
    }


    private class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    }

}
