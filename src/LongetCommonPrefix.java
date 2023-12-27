public class LongetCommonPrefix
{
    public static String longestCommonPrefix(String[] strs)
    {
        if(strs.length == 0) return "";

        int min_len=Integer.MAX_VALUE;
        for(int i=0;i<strs.length;i++)
            min_len = Math.min(min_len, strs[i].length());

        if(min_len==0) return "";

        String res="";
        for(int i=0;i<min_len;i++)
        {
            for(int j=0;j<strs.length;j++)
            {
                if(strs[j].charAt(i)!=strs[0].charAt(i))
                    return res;
            }
            res+=strs[0].charAt(i);
        }
        return res;
    }

    public static void main(String[] args)
    {
        String[] arr = {"ab", "a"};
        System.out.println(longestCommonPrefix(arr));

        System.out.println("   ".trim()+"end");

    }
}
