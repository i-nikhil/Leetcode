import java.util.*;

public class MinimumArrows
{
    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int prevEnd = points[0][1];
        int ans = 1;
        for(int i= 1; i < points.length; i++){
            if(points[i][0] > prevEnd ){
                ans++;
                prevEnd = points[i][1];
            }else{
                prevEnd = Math.min(prevEnd,points[i][1]);
            }
        }

        return ans;
    }
    public static void main(String[] args)
    {
        System.out.println(findMinArrowShots(new int[][]{{1, 2}, {4,5}, {1,5}}));
        System.out.println(findMinArrowShots(new int[][]{{2,3},{2,2},{3,3},{1,3},{5,7},{2,2},{4,6}}));
        System.out.println(findMinArrowShots(new int[][]{{1, 3}, {2, 6}, {6,10}, {15, 18},{19,21}}));
        System.out.println(findMinArrowShots(new int[][]{{1,4},{2,3}}));
    }
}
