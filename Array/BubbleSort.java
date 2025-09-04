import java.util.*;
public class BubbleSort{
    public static void bubble(int arr[])
    {
        for(int i=0;i<arr.length-1;i++)
        {
            for(int j=0;j<arr.length-i-1;j++)
            {
                if(arr[j]>arr[j+1])
                {
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }

    }
    public static void main(String args[])
    {
        int arr[]={1,2,5,6,3,1,8,7,9};

        
        System.out.println("Before Sorting"+Arrays.toString(arr));
        bubble(arr);
        System.out.println("After Sorting" +Arrays.toString(arr));
    }
}