import java.util.*;

// Approach:  Prefix sum + Sweep Line

// Convert time into Event
public class ServerLoadThreshold {

    static class Event {
        long time;
        long delta;

        Event(long time, long delta) {
            this.time = time;
            this.delta = delta;
        }
    }

    public static long earliestSecond(long[] start, long[] end, long limit) {
        List<Event> events = new ArrayList<>();

        for (int i = 0; i < start.length; i++) {
            events.add(new Event(start[i], 1));
            events.add(new Event(end[i] + 1, -1));
        }

        // Sort the Event on time

        events.sort(Comparator.comparingLong(e -> e.time));

        // Check first time limit gone breach

        long currentLoad = 0;
        long totalLoad = 0;
        long prevTime = events.get(0).time;

        for (Event e : events) {
            long duration = e.time - prevTime;

            if (currentLoad > 0) {
                long added = currentLoad * duration;
                if (totalLoad + added >= limit) {
                    long remaining = limit - totalLoad;
                    long secondsNeeded = (remaining + currentLoad - 1) / currentLoad;
                    return prevTime + secondsNeeded;
                }
                totalLoad += added;
            }

            currentLoad += e.delta;
            prevTime = e.time;
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            long[] start = new long[n];
            long[] end = new long[n];

            for (int i = 0; i < n; i++)
                start[i] = sc.nextLong();
            for (int i = 0; i < n; i++)
                end[i] = sc.nextLong();

            long limit = sc.nextLong();
            System.out.println(earliestSecond(start, end, limit));
        }
        sc.close();
    }
}
