import java.util.*;

public class LongestSubstringWithoutRepeating {
    
    public static int Longest(String s)
    {
        Set<Character> set=new HashSet<>();
        int left=0;int maxLen=0;
        for(int i=0;i<s.length();i++)
        {
            char c =s.charAt(i);
            //shrink
            while(set.contains(c))
            {
                set.remove(s.charAt(left));
                left++;
            }
                set.add(c);
                maxLen=Math.max(maxLen, i-left+1);

            
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String  s="bcdefabfdedfddaadefgghjikl";
        System.out.println(Longest(s));

    }
}
