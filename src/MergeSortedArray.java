import java.util.Arrays;

public class MergeSortedArray
{
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0, i;
        int[] arr = new int[m+n];
        for(i=0;p1<m && p2<n;i++)
        {
            if(nums1[p1]<nums2[p2])
                arr[i]=nums1[p1++];
            else
                arr[i]=nums2[p2++];
        }

        if(p1<m)
        {
            for(int j=p1; j<m;j++)
            {
                arr[i++]=nums1[j];
            }
        }
        else if(p2<n)
        {
            for(int j=p2; j<n;j++)
                arr[i++]=nums2[j];
        }

        System.arraycopy(arr, 0, nums1, 0, m + n);
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0}, nums2 = {2,5,6};

        merge(nums1, 3, nums2, 3);

        System.out.println(Arrays.toString(nums1));

    }
}
