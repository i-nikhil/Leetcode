import java.util.Arrays;

public class RotateArray
{
    public static void rotate(int[] nums, int k)
    {
        k = k%nums.length;
        if(nums.length<=1)return;
        reverse(nums, 0, nums.length-k-1);
        reverse(nums, nums.length-k, nums.length-1);
        reverse(nums, 0, nums.length-1);
    }

    private static void reverse(int[] nums, int start, int end) {
        int mid = ((end - start + 1) / 2) + start;

        while (start < mid)
        {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};

        rotate(arr, 3);

        System.out.println(Arrays.toString(arr));

    }
}
