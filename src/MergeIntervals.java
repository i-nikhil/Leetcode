import java.util.*;
class Interval
{
    int start, end;
    public Interval(int start, int end)
    {
        this.start = start;
        this.end = end;
    }
}

public class MergeIntervals
{
    public static int[][] merge(int[][] intervals)
    {
        List<Interval> l = new ArrayList<>();
        for (int[] interval : intervals) l.add(new Interval(interval[0], interval[1]));
        Comparator<Interval> c=Comparator.comparingInt(o->o.start);
        l.sort(c);
        List<Interval> merged = new ArrayList<>();
        merged.add(l.get(0));
        int last_end=l.get(0).end;
        for(int i=1;i<l.size();i++)
        {
            if(l.get(i).start<=last_end)
            {
                Interval update_old = merged.get(merged.size()-1);
                update_old.end = Math.max(update_old.end, l.get(i).end);
                merged.set(merged.size()-1, update_old);
                last_end = update_old.end;
            }
            else
            {
                merged.add(l.get(i));
                last_end = l.get(i).end;
            }
        }
        int[][] res = new int[merged.size()][2];

        for(int i=0;i<res.length;i++) {
            res[i][0]=merged.get(i).start;
            res[i][1]=merged.get(i).end;
        }
        return res;
    }

    public static void main(String[] args)
    {
        System.out.println(Arrays.deepToString(merge(new int[][]{{2,3},{2,2},{3,3},{1,3},{5,7},{2,2},{4,6}})));
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 3}, {2, 6}, {6,10}, {15, 18}})));
        System.out.println(Arrays.deepToString(merge(new int[][]{{1,4},{2,3}})));
    }
}