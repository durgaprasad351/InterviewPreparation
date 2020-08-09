package sorting;

import java.util.ArrayList;
import java.util.List;

public class MergingIntervals {

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval( -4,-2 ));
        intervals.add(new Interval( 0,2 ));
        intervals.add(new Interval( 3,5 ));
        intervals.add(new Interval( 7,9 ));

        Interval newInterval = new Interval( 1,10 );
        merge(intervals, newInterval);
    }

    private static void merge(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        int i =0;
        while( intervals.get(i).right < newInterval.left  ){
            result.add( intervals.get(i) );
            i++;
        }
        int j= i;
        while( j < intervals.size() &&  intervals.get( j ).left < newInterval.right ){
            j++;
        }
        result.add( new Interval( Math.min( intervals.get(i).left, newInterval.left ), Math.max( intervals.get(j-1).right, newInterval.right ) ) );
        result.addAll( intervals.subList( j ,  intervals.size()  ) );
        System.out.println(result);
    }
}

class Interval{
    int left;
    int right;
    public Interval(int left, int right){
        this.left = left;
        this.right = right;
    }

    @Override public String toString() {
        return "[" + left + ", " + right + "]";
    }
}
