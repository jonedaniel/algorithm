package leetcode.easy;

import org.junit.Test;

import java.util.PrimitiveIterator;

/**
 * Title: GuessNumberHigherOrLower
 * Description:
 * <p>
 * We are playing the Guess Game. The game is as follows:
 * <p>
 * I pick a number from 1 to n. You have to guess which number I picked.
 * <p>
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
 * <p>
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 * <p>
 * -1 : My number is lower
 * 1 : My number is higher
 * 0 : Congrats! You got it!
 * Example :
 * <p>
 * Input: n = 10, pick = 6
 * Output: 6
 *
 * @author zhaomenghui
 * @version 1.0
 * @url https://leetcode.com/problems/guess-number-higher-or-lower/
 * @createDate 2019/1/21
 */
public class GuessNumberHigherOrLower {
    int compare = 1;

    /**
     *  holyshit motherfucker
     * @author zhaomenghui
     * @createDate 2019/1/21
     */
    public static void main(String[] args) {
        System.out.println(new GuessNumberHigherOrLower().guessNumber(10));
    }

    /*
    The guess API is defined in the parent class GuessGame.
    @param num, your guess
    @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
    int guess(int num);
    */
    public int guessNumber(int n) {
        return recursive(1,n);
    }

    private int recursive(int min, int max) {
        int mid = (min + max) /2;
        int guess = guess(mid);
        if (guess == 0) {return mid;
        } else if (guess == 1) {return recursive(min,mid-1);
        } else {return recursive(mid+1,max);
        }
    }

    private int guess(int num){
        return Integer.compare(num,compare);
    }

}
