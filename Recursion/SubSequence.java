// Problem statement: find the maximum length of subsequence

// Approach: We will follow bottom up approach(comparing elements of the strings from the last)

// Case 1: Condition when element get matched then increase the length by 1.

// Case 2: Codition when element did not matched then we will divide the into two cases and remove element one by one from both 

// strings in different cases


public class SubSequence{
    public static int lcs(String s1, String s2, int m, int n)
    {
        if(n==0|| m==0)
        {
            return 0;
        }
        
        //Case1:

        if(s1.charAt(m-1)==s2.charAt(n-1))
        {
            return lcs(s1, s2, n-1, m-1)+1;
        }
        else{
            int ans1=lcs(s1, s2, m-1, n);
            int ans2=lcs(s1, s2, m, n-1);
            return Math.max(ans1, ans2);


        }
    }
    public static void main(String[] args) {
        String s1="abcdef";
        String s2="abedg";
        System.out.println(lcs(s1, s2, s1.length(), s2.length()));
    }
}


