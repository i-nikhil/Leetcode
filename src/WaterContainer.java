public class WaterContainer
{
    public static int maxArea(int[] height)
    {
        int p1 = 0, p2 = height.length-1;
        int water=0;
        while(p1<p2)
        {
            water = Math.max(water,((p2+1)-(p1+1))*Math.min(height[p1],height[p2]));
            if(height[p1]<height[p2]) p1++;
            else p2--;
        }
        return water;
    }

    public static void main(String[] args)
    {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));//49
        System.out.println(maxArea(new int[]{1,2,1}));//2
    }
}
