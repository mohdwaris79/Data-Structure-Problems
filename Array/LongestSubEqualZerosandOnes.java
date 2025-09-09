
import java.util.HashMap;

public class LongestSubEqualZerosandOnes {
    public static int Longest(int arr[], int k)
    {
        HashMap<Integer, Integer> map=new HashMap<>();
        int maxLen=0;
        int sum=0;
        for(int i:arr)
        {
            sum+=(arr[i]==0?-1:1);
            if(sum==0)
            {
                maxLen=i+1;
            }
            if(map.containsKey(sum))
            {
                maxLen=Math.max(maxLen, i-map.get(sum));
            }
            else{
                map.put(sum,i);
            
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int arr[]={0,1,0,1,1,0};
        int k=4;
        System.out.println(Longest(arr, k));
    }
    
}
