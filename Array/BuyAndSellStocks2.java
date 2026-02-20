public class BuyAndSellStocks2 {
    public static int stock(int price[])
    {
        int n=price.length;
        if (price == null || price.length < 2)
        {
            return 0;
        }
        int profit=0;
        for(int i=1;i<n;i++)
        {
            if(price[i-1]<price[i])
            {
                profit+=price[i]-price[i-1];
            }
        }
        return  profit;
    }
    public static void main(String[] args) {
        int price[]={4,5,6,8,9,2,3};
        System.out.println(stock(price));
    }
}
