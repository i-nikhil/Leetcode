public class HappyNumber
{
    public static boolean isHappy(int n)
    {
        int d,val=0, i=0;
        while(i<10)
        {
            if(val==1) return true;
            val=0;
            while(n>0)
            {
                d=n%10;
                val+=d*d;
                n=n/10;
            }
            n=val;
            i++;
        }
        return false;
    }

    public static void main(String[] args)
    {
        System.out.println(isHappy(19));

    }
}
