import java.util.*;
public class HighReach{
    public static class Band{
        long time; long delta;
        Band(long time, long delta)
        {
            this.time =time;
            this.delta= delta;
        }
    }
    public static long high(int st[], int end[], long usage[], long limit)
    {
        int n=st.length;
        List<Band>events=new ArrayList<>();


        // created weighted events

        for(int i=0; i<n;i++)
        {
            events.add(new Band(st[i], usage[i]));
            events.add(new Band((long) end[i]+1, -usage[i]));

        }

        // sort the events on time

        events.sort(Comparator.comparingLong(e->e.time));
        long currUsage=0;
        for(Band b:events)
        {
            currUsage+=b.delta;
            if(currUsage>limit)
            {
                return b.time;
            }
        }
        return -1;
    }
     public static void main(String[] args) {
        int[] st = {1, 2, 3};
        int[] end = {4, 5, 6};
        long[] usage = {3, 2, 4};
        long limit = 8;

        System.out.println(high(st, end, usage, limit)); // 3
    }
}
    
