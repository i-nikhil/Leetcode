import java.util.*;
public class BasicCalculator
{
    public static int calculate(String str) {
        // Remove spaces and unary operators
        StringBuilder strBuilder = new StringBuilder(str.replaceAll(" ", ""));
        for (int i = 0; i < strBuilder.length(); i++) {
            if (strBuilder.charAt(i) == '+' || strBuilder.charAt(i) == '-') {
                if (i == 0)
                    strBuilder.insert(0, "0");
                else if (strBuilder.charAt(i + 1) == '('
                        && (strBuilder.charAt(i - 1) == '(' || strBuilder.charAt(i - 1) == '+'
                        || strBuilder.charAt(i - 1) == '-'))
                    strBuilder.insert(i, "0");
                i++;
            }
        }
        str = strBuilder.toString();

        // Format input
        List<String> input = new ArrayList<>();
        StringBuilder num = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i)))
                num.append(str.charAt(i));
            else if ((str.charAt(i) == '+' || str.charAt(i) == '-')
                    && Character.isDigit(str.charAt(i + 1))
                    && num.isEmpty() && (input.isEmpty() || input.get(input.size() - 1).equals("(")
                    || input.get(input.size() - 1).equals("+") || input.get(input.size() - 1).equals("-")))
                num.append(str.charAt(i));
            else {
                if (!num.isEmpty())
                    input.add(num.toString());
                input.add("" + str.charAt(i));
                num = new StringBuilder();
            }
        }
        if (!num.isEmpty())
            input.add(num.toString());

        // Convert infix to postfix
        List<String> postfix = new ArrayList<>();
        Stack<String> s = new Stack<>();

        for (String i : input) {
            if (i.equals(")")) {
                if (!s.isEmpty() && s.peek().equals("("))
                    s.pop();
                while (!s.isEmpty() && !s.peek().equals("("))
                    postfix.add(s.pop());
            } else if (i.equals("(") || i.equals("+") || i.equals("-"))
                s.push(i);
            else {
                postfix.add(i);
                if (!s.isEmpty() && (s.peek().equals("+") || s.peek().equals("-")))
                    postfix.add(s.pop());
            }
        }

        // Evaluate reverse polish notation
        int a, b;
        for (String o : postfix) {
            switch (o) {
                case "+":
                    s.push(String.valueOf(Integer.parseInt(s.pop()) + Integer.parseInt(s.pop())));
                    break;
                case "-":
                    b = Integer.parseInt(s.pop());
                    a = Integer.parseInt(s.pop());
                    s.push(String.valueOf(a - b));
                    break;
                default:
                    s.push(o);
            }
        }
        return Integer.parseInt(s.peek());
    }

    public static void main(String[] args)
    {
        System.out.println(calculate("- (3 - (- (4 + 5) ) )"));
        System.out.println(calculate("- (3 + (4 + 5))"));
        System.out.println(calculate("1-(     -2)"));
        System.out.println(calculate("2-1 + 2"));
        System.out.println(calculate("-2+ 1"));
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
