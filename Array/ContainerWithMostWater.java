public class ContainerWithMostWater {
    public static int mostWater(int height[])
    {
        int left=0; 
        int right=height.length-1;
        int maxArea=0;
        while(left<right)
        {
            int w=right-left;
            int h=Math.min(height[left], height[right]);
            int area=w*h;
            maxArea=Math.max(maxArea, area);

        
        if(height[left]<height[right])
        {
            left++;
        }
    
        else{
            right--;
        }
    }
        return maxArea;


    }

    public static void main(String args[])
    {
        int h[]={5,6,3,9,7,4,10,1,5};
        System.out.println(mostWater(h));
    }
    
}
