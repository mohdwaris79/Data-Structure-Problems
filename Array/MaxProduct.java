public class MaxProduct {
    public static int maxProd(int num[]) {
        int maxProd = num[0];
        int minProd = num[0];
        int res = num[0];

        for (int i = 1; i < num.length; i++) {
           
            if (num[i] < 0) {
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }

           
            maxProd = Math.max(num[i], maxProd * num[i]);
            minProd = Math.min(num[i], minProd * num[i]);

            
            res = Math.max(res, maxProd);
        }
        return res;
    }

    public static void main(String[] args) {
        int num[] = {4, 6, -7, 2, 3, 6};
        System.out.println(maxProd(num)); 
    }
}
