public class SubArray {
    public static void  SubArray(int num[])
    {
        for(int i=0;i<num.length;i++)
        {
            for(int j=i;j<num.length;j++)
            {
                for(int k=i;k<=j;k++)
                {
                    System.out.println(num[k]+"");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int num[]={2,4,6,8,10,20};
        SubArray(num);
    }
}
