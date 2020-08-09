package sorting;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComputeTheUnionOfIntervals {
    public static void main(String[] args) {
        List<Point> points = new ArrayList<>();
        points.add( new Point( 0, true )  );
        points.add( new Point( 3, false )  );

        points.add( new Point( 1, true )  );
        points.add( new Point( 1, false )  );

        points.add( new Point( 2, true )  );
        points.add( new Point( 4, false )  );

        points.add( new Point( 3, true )  );
        points.add( new Point( 4, false )  );

        points.add( new Point( 5, true )  );
        points.add( new Point( 7, false )  );

        points.add( new Point( 7, true )  );
        points.add( new Point( 8, false )  );

        points.add( new Point( 8, true )  );
        points.add( new Point( 11, false )  );

        points.add( new Point( 9, true )  );
        points.add( new Point( 11, false )  );

        points.add( new Point( 12, true )  );
        points.add( new Point( 14, false )  );

        points.add( new Point( 12, true )  );
        points.add( new Point( 16, false )  );

        points.add( new Point( 13, true )  );
        points.add( new Point( 15, false )  );

        points.add( new Point( 16, true )  );
        points.add( new Point( 17, false )  );

        Collections.sort(points);

        System.out.println(points);

        int intervalStart = 0;
        int length = 0;
        for(int i=0; i< points.size(); i++ ){
            if(points.get( i ).isStart){
                length ++;
            }else{
                length --;
            }
            if(length == 0){
                System.out.println(" New INterval  [" + points.get(intervalStart).val + " ," + points.get(i).val);
                intervalStart = i+1;
            }
        }
    }

}

class Point implements  Comparable{

    int val;
    boolean isStart;

    public Point(int val, boolean isStart){
        this.val = val;
        this.isStart = isStart;
    }

    @Override public String toString() {
        return "[ " + val + ", " + isStart + "]";
    }

    @Override public int compareTo(Object o) {
        Point p = (Point)o;
        if (p.val == val  ){
            return p.isStart ? 1 : -1;
        }
        return Integer.compare( val, p.val ) ;
    }
}



