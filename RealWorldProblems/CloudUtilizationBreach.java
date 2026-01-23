import java.util.*;
public class CloudUtilizationBreach {


    static class Event {
        int time;
        int cpu;
        Event(int t, int c) {
            time = t;
            cpu = c;
        }
    }

    public static int findBreachTime(int[][] intervals, int limit) {
        List<Event> events = new ArrayList<>();

        for (int[] in : intervals) {
            events.add(new Event(in[0], in[2]));   // start
            events.add(new Event(in[1], -in[2]));  // end
        }

        events.sort((a, b) -> {
            if (a.time != b.time) return a.time - b.time;
            return b.cpu - a.cpu; // start before end
        });

        long currentCPU = 0;

        for (Event e : events) {
            currentCPU += e.cpu;
            if (currentCPU > limit) {   // Checking the condition 
                return e.time;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] intervals = {
            {1, 5, 3},
            {2, 6, 4},
            {4, 7, 2}
        };
        int L = 7;

        System.out.println(findBreachTime(intervals, L));
    }
}
