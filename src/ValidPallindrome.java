public class ValidPallindrome
{
    public static boolean isPalindrome(String s)
    {
        if(s.length()<=1)return true;

        int i=0, j=s.length()-1;
        while(i<s.length() && j>0)
        {
            while(i<s.length() && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while(j>0 && !Character.isLetterOrDigit(s.charAt(j))) j--;

            if(i==j || i>=s.length() || j<=0) break;
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
                return false;
            i++; j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(",,,,,,,,,,,,acva"));
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
