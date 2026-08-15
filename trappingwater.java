public class trappingwater
{
    
    public static void trap(int height[])
    {
        //cal left max boundary
        int leftMax[] = new int[height.length];
        leftMax[0] = height[0];
        for (int i=1;i<height.length;i++)
        {
            leftMax[i] = Math.max(leftMax[i-1],height[i]);
        }
        //cal right max boundary
        int rightMax[] = new int[height.length];
        rightMax[height.length-1] = height[height.length-1];
        for(int i=height.length-2;i>=0;i--)
        {
            rightMax[i] = Math.max(rightMax[i+1],height[i]);
        }
        //loop
        int water = 0;
        for(int i=0;i<height.length;i++)
        {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            water += waterLevel - height[i];
        }
        System.out.println("Trapped water: " + water);
    }
    
    public static void main(String[] args)
    {
        int height[] = {0,5,0,2,1,0,1,3,2,1,7,1};
        trap(height);
    }
}
