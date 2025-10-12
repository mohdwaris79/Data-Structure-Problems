import java.util.*;

// helper class to store start and end time of a meeting
class Pair {
    int start, end;
    Pair(int s, int e) {
        start = s;
        end = e;
    }
}


public class Meeting {

    public static int maxMeetings(int start[], int end[], int n) {
        List<Pair> meetings = new ArrayList<>();
        
        
        for (int i = 0; i < n; i++) {
            meetings.add(new Pair(start[i], end[i]));
        }
        
        
        meetings.sort((a, b) -> a.end - b.end);
        
        int count = 0;
        int lastEnd = -1;
        
        
        for (Pair m : meetings) {
            if (m.start > lastEnd) {  
                count++;
                lastEnd = m.end;
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[]   = {2, 4, 6, 7, 9, 9};
        int n = start.length;
        
        System.out.println(maxMeetings(start, end, n)); 
        // Output: 4
    }
}
