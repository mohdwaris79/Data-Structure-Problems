public class CountStringsWithoutConsecOnes {
    

    public int countBinaryStrings(int n) {
        if (n == 1) return 2;

        int dp0 = 1;                   // dp0 for the zero integer
        int dp1 = 1;                   // dp1 for the one

        for (int i = 2; i <= n; i++) {
            int newDp0 = dp0 + dp1;         // if the last index is zero then we can add anything after zero
            int newDp1 = dp0;               // if the last indext is one so we only can add anything after zero

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
