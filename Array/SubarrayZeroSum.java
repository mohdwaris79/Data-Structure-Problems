import java.util.HashSet;
import java.util.Set;

public class SubarrayZeroSum {
    public static boolean  subarrayZeroSum(int arr[])
    {
        Set<Integer> s=new HashSet<>();
        int prefixSum=0;
        for(int i:arr)
        {
            prefixSum+=i;
            if(prefixSum==0||s.contains(prefixSum))
            {return true;}
        s.add(prefixSum);
        }
        return false;
    }
    public static void main(String[] args) {
        int arr[]={4, 2, -3, 1, 6};
        System.err.println(subarrayZeroSum(arr));
    }
    
}
