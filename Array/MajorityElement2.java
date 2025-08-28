import java.util.*;
public class MajorityElement2{
    public static int majority(int num[])
    {
        int n=num.length;
        Map<Integer, Integer> mp=new HashMap<>();
        for(int i:num)
        {
            mp.put(i,mp.getOrDefault(i,0)+1);
            if(mp.get(i)>n/2){
                return i;
            }
        }
        return -1;
    }
    public static void main(String args[])
    {
        int arr[]={2,1,4,2,3,5,2,8,2,2,2,9,2,2};
        System.out.println(majority(arr));
    }
}