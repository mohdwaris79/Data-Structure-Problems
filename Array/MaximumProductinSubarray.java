public class MaximumProductinSubarray {
    public static int maxProduct(int arr[])
    {
        int n=arr.length;
        int maxProd=arr[0];
        int minProd=arr[0];
        int res=arr[0];
        for(int i=1;i<n;i++)
        {
            int num=arr[i];
            if(num<0)
            {
                //swap
                int temp=maxProd;
                maxProd=minProd;
                minProd=temp;
            }

                maxProd=Math.max(num, maxProd*num);
                minProd=Math.min(num, minProd*num);
                res=Math.max(res, maxProd);
            
        }
        return res;

    }
    public static void main(String args[])
    {
        int arr[]={1,2,3,4,-5,6};
        System.out.println(maxProduct(arr));
    }
}
