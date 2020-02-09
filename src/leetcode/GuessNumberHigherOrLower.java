package leetcode;

public class GuessNumberHigherOrLower {
	private int pick;
	private GuessNumberHigherOrLower(int pick,int n){
		this.pick = pick;
		guessNumber(n);
	}
	private int guess(int guess){
		int compare = pick - guess;
		if(compare>0) {
			return 1;
		}else if(compare==0){
			return 0;
		}else {
			return -1;
		}
	}
	public int guessNumber(int n) {
		if(n==1){
			return 1;
		}
		int left = 1;
		int right = n;
		while(true){
			int guess = ((right-left)>>>1)+left;
			int resultGuess = guess(guess);
			if(resultGuess > 0){
				left = (right-guess)==1?guess+1:guess;
			}else if(resultGuess < 0){
				right = guess;
			}else {
				System.out.println(guess);
				return guess;
			}
		}
	}

	public static void main(String[] args) {
		GuessNumberHigherOrLower guessNumber = new GuessNumberHigherOrLower(1702766719,2126753390);
	}
}
