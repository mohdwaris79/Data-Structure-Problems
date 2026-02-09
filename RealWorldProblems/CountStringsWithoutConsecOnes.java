public class CountStringsWithoutConsecOnes {
    

    public int countBinaryStrings(int n) {
        if (n == 1) return 2;

        int dp0 = 1;
        int dp1 = 1;

        for (int i = 2; i <= n; i++) {
            int newDp0 = dp0 + dp1;
            int newDp1 = dp0;

            dp0 = newDp0;
            dp1 = newDp1;
        }

        return dp0 + dp1;
    }

    
 public static void main(String[] args) {
        CountStringsWithoutConsecOnes st = new CountStringsWithoutConsecOnes();

        int n = 4; 
        int result = st.countBinaryStrings(n);

        System.out.println("Number of valid binary strings of length " + n + " = " + result);
    }
}
