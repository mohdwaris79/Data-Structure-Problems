public class BuyAndSellStocks {
    public static int bss(int price[])
    {
        int buyPrice=Integer.MAX_VALUE;
        int maxProfit=0;
        for(int i=0;i<price.length; i++)
        {
            if(buyPrice<price[i])
            {
                int profit=price[i]-buyPrice;
                maxProfit=Math.max(maxProfit,profit);
            }
            else{
                buyPrice=price[i];
            }
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int price[]={40,50,500,700,100,2000,6000,8000};
        System.out.println(bss(price));
    }
}
