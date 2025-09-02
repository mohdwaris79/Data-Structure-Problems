public class Panagram{
    public static boolean panagram(String str)
    {
         str=str.toLowerCase();
         boolean seen[]=new boolean[26];
         for(int i=0;i<str.length();i++)
         {
            char ch=str.charAt(i);
            if(ch>='a'&&ch<='z')
            {
             seen[ch-'a']=true;

            }
         }
         for(boolean b:seen){
            if(!b)
            {
                return false;

            }
        }
            return true;
         
        }
         public static void main(String args[])
         {
            String str="abcdefghijklmnopqrstuvwxyz";
            System.out.println(panagram(str)? "String is panagram "
            :"String is not Panagram");
         
        }
    }
