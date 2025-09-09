import java.util.*;
public class AssignMiceHoles{
    public static int Assign(int mice[], int holes[])
    {
        Arrays.sort(mice);
        Arrays.sort(holes);
        int maxTime=0;
        for(int i=0;i<mice.length;i++)
        {
            maxTime=Math.max(maxTime, Math.abs(mice[i]-holes[i]));


        }
        return maxTime;
    }

   public static void main(String[] args) {
        int[] mices = {4, -4, 2};
        int[] holes = {4, 0, 5};
        System.out.println(Assign(mices, holes)); // Output: 4
    }
}