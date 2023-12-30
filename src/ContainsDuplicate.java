import java.util.*;
public class ContainsDuplicate
{
    public static boolean containsNearbyDuplicate(int[] nums, int k)
    {
        if(k==0) return false;
        Set<Integer> s = new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            if(s.contains(nums[i])) return true;
            if(i<k) s.add(nums[i]);
            else {
                s.remove(nums[i-k]);
                s.add(nums[i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1}, 3));//true
        System.out.println(containsNearbyDuplicate(new int[]{99,99}, 2));//true
        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));//false
    }
}
