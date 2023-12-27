import java.util.Arrays;

public class PaypalZigzag
{
    public static String convert(String s, int numRows) {

        if(numRows==1) return s;
        String[] rows = new String[numRows];

        Arrays.fill(rows, "");

        int idx = 0, rev_flag = 0;
        for (int i = 0; i < s.length(); i++) {
            if (idx == numRows) {
                idx -= 2;
                rev_flag = 1;
            }
            else if (idx == -1) {
                idx = 1;
                rev_flag = 0;
            }
            rows[idx] += s.charAt(i);
            if(rev_flag==1) idx--; else idx++;
        }
        StringBuilder res = new StringBuilder();
        for (String str : rows) {
            res.append(str);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 2));
    }
}
