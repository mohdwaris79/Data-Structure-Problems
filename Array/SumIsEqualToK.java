
import java.util.HashMap;
import java.util.Map;


public class  SumIsEqualToK{



public static  int maxSum(int num[], int k){

    Map<Integer, Integer> map=new HashMap<>();
    int sum=0;
    int maxLen=0;
    for(int i=0;i<num.length;i++)
    {
        sum=sum+num[i];
        if(sum==k)
        {
            maxLen=i+1;

        }
        if(map.containsKey(sum-k)){
            maxLen=Math.max(maxLen, i-map.get(sum-k));
        }
        if(!map.containsKey(sum)){
            map.put(sum,i);
        }

    }
    return maxLen;
}
public static void main(String[] args) {
    int num[]={1,2,3,1,1,1,1,3};
    int k=6;
    System.out.println(maxSum(num, k));
}
}