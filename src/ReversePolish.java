import java.util.*;
public class ReversePolish
{
    public static int evalRPN(String[] tokens)
    {
        Stack<String> s = new Stack<>();
        int a,b;
        for(String str:tokens)
        {
            switch(str)
            {
                case "+": s.push(String.valueOf(Integer.parseInt(s.pop())+Integer.parseInt(s.pop()))); break;
                case "-": b=Integer.parseInt(s.pop()); a=Integer.parseInt(s.pop()); s.push(String.valueOf(a-b)); break;
                case "*": s.push(String.valueOf(Integer.parseInt(s.pop())*Integer.parseInt(s.pop()))); break;
                case "/": b=Integer.parseInt(s.pop()); a=Integer.parseInt(s.pop()); s.push(String.valueOf(a/b)); break;
                default : s.push(str);
            }
        }
        return Integer.parseInt(s.peek());
    }

    public static void main(String[] args)
    {
        System.out.println(evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
        System.out.println(evalRPN(new String[]{"1","4","5","+","2","+","+","3","-","6","8","+","+"}));
    }
}
