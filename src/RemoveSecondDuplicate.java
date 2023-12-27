import java.util.Arrays;

public class RemoveSecondDuplicate
{
    public static int removeDuplicates(int[] nums)
    {
        int idx = 2;
        for(int i=2;i<nums.length;i++)
        {
            if(nums[i]!=nums[i-2])
            {
                nums[idx]=nums[i];
                idx++;
            }
        }
        return idx;
    }

    public static void main(String[] args)
    {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
