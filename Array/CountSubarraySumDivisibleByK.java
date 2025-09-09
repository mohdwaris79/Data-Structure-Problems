
import java.util.HashMap;

public class CountSubarraySumDivisibleByK {
    public static int CountSubarray(int arr[], int k)
    {
        HashMap<Integer, Integer> map=new HashMap<>();
        int count=0;
        int sum=0;
        map.put(0,1);
        for(int i:arr)
        {
            sum+=i;
        
            int rem=sum%k;
            if(rem<0)
            {
                    rem+=k;
            }
               if (map.containsKey(rem)) {
                count += map.get(rem); 
            } 
                map.put(rem, map.getOrDefault(rem, 0) + 1);
                
        }
            return count;
        
    }
    public static void main(String[] args) {
        int arr[]={4,5,6,-7,2,6};
        int k=3;
        System.out.println(CountSubarray(arr, k));
    }
}
