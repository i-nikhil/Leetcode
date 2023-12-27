import java.util.Stack;

public class Candy
{
    public static int candy(int[] ratings)
    {
        int candies=1,prev_candie=1;

        Stack<Integer> reduce = new Stack<>();
        for(int i=0;i<ratings.length-1;i++)
        {
            if(ratings[i+1]>ratings[i] && reduce.empty())
            {
                candies+=prev_candie+1;
                prev_candie=prev_candie+1;
            }
            else if(ratings[i+1]>ratings[i] && !reduce.empty())
            {
                reduce.push(ratings[i]);
                candies+=((reduce.size()*(reduce.size()+1))/2)+1;
                prev_candie=2;
                reduce.removeAllElements();
            }
            else if(ratings[i+1]<ratings[i] && i+1==ratings.length-1 && reduce.empty())
            {
                if(prev_candie==1)
                candies+=2;
                else candies+=1;
            }
            else if(ratings[i+1]<ratings[i])
            {
                reduce.push(ratings[i]);
            }
            else if(ratings[i+1]==ratings[i] && reduce.empty())
            {
                candies+=1;
                prev_candie=1;
            }
            else if(ratings[i+1]==ratings[i] && !reduce.empty())
            {
                reduce.push(ratings[i]);
                candies-=prev_candie;
                candies+=((reduce.size()*(reduce.size()+1))/2)+1;
                prev_candie=1;
                reduce.removeAllElements();
            }
        }
        if(!reduce.empty())
        {
            candies-=prev_candie;
            reduce.push(ratings[ratings.length-1]);
            candies+=(reduce.size()*(reduce.size()+1))/2;
        }
        return candies;
    }

    public static void main(String[] args) {
        int[] ratings1 = {1,2,87,87,87,2,1};
        int[] ratings2 = {1,3,2,2,1};
        int[] ratings3 = {1,3,4,5,2};
        int[] ratings4 = {1,2,3,1,0};

        System.out.println(candy(ratings1));//13
        System.out.println(candy(ratings2));//7
        System.out.println(candy(ratings3));//11
        System.out.println(candy(ratings4));//9
    }
}
