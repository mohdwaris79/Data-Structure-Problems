public class Fibonacci{
    public static int []fibonacci(int n)
    {
     int fib[]=new int [n];
     
        if(n>=1)
        {
            fib[0]=0;
        }
        if(n>=2)
        {
            fib[1]=1;
        }
        for(int i=2;i<n;i++)
     {
        fib[i]=fib[i-1]+fib[i-2];
     }
     return fib;
    }
   public static void main(String[] args){

        int n = 5;
        int res[] = fibonacci(n);   

        for (int num : res) {
            System.out.println(num);   
        }
    }
}