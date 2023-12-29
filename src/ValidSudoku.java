import java.util.*;
public class ValidSudoku
{
    public static boolean isValidSudoku(char[][] board)
    {
        Map<Integer, HashSet<Character>> row = new HashMap<>();
        Map<Integer, HashSet<Character>> column = new HashMap<>();
        Map<String, HashSet<Character>> cube = new HashMap<>();//key = i+""+j

        for(int i=0;i<9;i++)
        {
            row.put(i,new HashSet<>());
            column.put(i,new HashSet<>());
        }

        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                cube.put(i+""+j, new HashSet<>());

        for(int i=0; i<9;i++)
        {
            for(int j=0; j<9;j++)
            {
                if(board[i][j]=='.') continue;

                if(
                        row.get(i).contains(board[i][j])
                        || column.get(j).contains(board[i][j])
                        || cube.get(i/3+""+j/3).contains(board[i][j])
                )
                    return false;

                row.get(i).add(board[i][j]);
                column.get(j).add(board[i][j]);
                cube.get(i/3+""+j/3).add(board[i][j]);
            }
        }
        return true;
    }
    public static void main(String[] args)
    {

        char[][] board = {
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println(isValidSudoku(board));
    }
}
