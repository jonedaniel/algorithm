package leetcode.medium;

import util.ArrayUtil;

import java.util.*;

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

public class IntervalListIntersections {

    public static void main(String[] args) {

    }

    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        List<Interval> list = new ArrayList<>();
        for (Interval ia : A) {
            for (Interval ib : B) {
                if (!(ia.end < ib.start) && !(ib.end < ia.start)) {
                    int start = ia.start >= ib.start ? ia.start : ib.start,
                            end = ia.end <= ib.end ? ia.end : ib.end;
                    list.add(new Interval(start, end));
                }
            }
        }
        return list.toArray(new Interval[0]);
    }
}
