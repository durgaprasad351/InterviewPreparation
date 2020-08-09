package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RenderCalander_Or_OverlappingIntervals {

    public static void main(String[] args) {
            Event e1 = new Event(1,10, "E1");
        Event e2 = new Event(5,15, "E2");
        Event e3 = new Event(12,20, "E3");
        Event e4 = new Event(14,30, "E4");
        List<Event> events = new ArrayList<>();
        events.add(e3);
        events.add(e1);
        events.add(e4);
        events.add(e2);
        overLappingIntervals(events);
        overLappingOptimal(events);
    }

    private static void overLappingOptimal(List<Event> events) {
        List<Intervel> intervals = new ArrayList<>();
        for(Event e : events){
            intervals.add( new Intervel(e.startTime, true) );
            intervals.add( new Intervel(e.endTime, false) );
        }
        Collections.sort(intervals);
        int max =0;
       int length =0;
        for(int i=0; i< intervals.size(); i++){
               if(intervals.get(i).isStart){
                   length++;
                   max = Math.max(max, length);
               }else{
                   length--;
               }
        }
        System.out.println(max);
    }

    private static void overLappingIntervals(List<Event> events) {
        Collections.sort( events );
        System.out.println(events);
        int max =0;
        int i=0;
        while(i +1 < events.size()){
           int j= i+1;
           int cnt =1;
           while(j < events.size() && events.get(j).startTime <  events.get(i).endTime){
               cnt++;
               j++;
           }
           max= Math.max(max, cnt);
           i = j-1;
        }
        System.out.println(max);
    }
}

class Intervel implements  Comparable{

    public long eventTs;
    public boolean isStart;

    public Intervel(long eventTs, boolean isStart){
        this.eventTs = eventTs;
        this.isStart = isStart;
    }

    @Override public int compareTo(Object o) {
        return Long.compare( eventTs, ((Intervel)o).eventTs);
    }
}

class Event implements  Comparable{
    public long startTime;
    public long endTime;
    public String name;
    public Event(long start, long end, String name){
        this.startTime = start;
        this.endTime = end;
        this.name = name;
    }

    @Override public int compareTo(Object o) {
        if(! (o  instanceof  Event)){
            throw new UnsupportedOperationException("We cannot compare arbitrary objects with Event");
        }
        return  Long.compare(  startTime ,   ((Event) o).startTime  );
    }

    @Override public String toString() {
        return  name;
    }
}
