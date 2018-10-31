package Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
//不是很懂这种比较方法？？
/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2.
 */
public class MeetingRoomII {
    public int minMeetingRooms(Interval[] intervals) {
        List<Point> list = new ArrayList<>(intervals.length*2);
        for(Interval i : intervals){
            list.add(new Point(i.start, 1));
            list.add(new Point(i.end, 0));
        }

        Collections.sort(list,Point.PointComparator);
        int count = 0, ans = 0;
        for(Point p : list){
            if(p.flag == 1) {
                count++;
            } else {
                count--;
            }
            ans = Math.max(ans, count);
        }

        return ans;
    }

    static class Point{
        int time;
        int flag;

        Point(int t, int s){
            this.time = t;
            this.flag = s;
        }
        public static Comparator<Point> PointComparator  = new Comparator<Point>(){
            public int compare(Point p1, Point p2){
                if(p1.time == p2.time) return p1.flag - p2.flag;
                else return p1.time - p2.time;
            }
        };
    }
}
