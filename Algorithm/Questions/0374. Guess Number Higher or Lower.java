/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 0;
        int right = n;
        int res, mid;
        while(left + 1 < right){
            mid = left + (right - left) / 2;
            res = guess(mid);
            if(res == 0) return mid;
            if (res > 0){
                left = mid;
            } else {
                right = mid;
            }
        }
        
        if (guess(left) == 0) return left;
        if (guess(right) == 0) return right;
        
        return -1;
    }
}