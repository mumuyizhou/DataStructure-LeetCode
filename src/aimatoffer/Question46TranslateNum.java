package aimatoffer;

/**
 * @author 木木漪
 */
public class Question46TranslateNum {
//	给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，
//	……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。

	double sqrt = Math.sqrt(5);

	public int translateNum(int num) {
		int translationCount = 1;
		int lenCount = 0;
		String numStr = Integer.toString(num);
		int strLen = numStr.length();
		if (numStr.charAt(0) == 49 || numStr.charAt(0) == 50) {
			lenCount++;
		}
		for (int i = 1; i < strLen; i++) {
			int numChar = numStr.charAt(i);
			if (numChar == 49 || numChar == 50) {
				lenCount++;
			} else if (numStr.charAt(i - 1) == 49 || ((!(numChar >= 54)) && numStr.charAt(i - 1) == 50)) {
				translationCount *= countOfLen(++lenCount);
				lenCount = 0;
			} else {
				translationCount *= countOfLen(lenCount);
				lenCount = 0;
			}
		}
		translationCount *= countOfLen(lenCount);
		return translationCount;
	}

	public int countOfLen(int len) {
		return (int) ((Math.pow((1 + sqrt) / 2, len + 1) - Math.pow((1 - sqrt) / 2, len + 1)) / sqrt);
	}

	/**
	 * @param num 使用动态规划
	 * @return
	 */
	public int translateNumUsingDp(int num) {
		String numStr = Integer.toString(num);
		int len = numStr.length();
		int[] dp = new int[len + 1];

		if(len == 1){
			return 1;
		}
		dp[0] = 1;
		dp[1] = 1;

		for(int i = 1; i < len; i++){
			int subInt = Integer.parseInt(numStr.substring(i - 1,i + 1));
			if(subInt <= 25 && subInt >= 10){
				dp[i + 1] = dp[i] + dp[i - 1];
			}else{
				dp[i + 1] = dp[i];
			}
		}
		return dp[len];
	}

	public static void main(String[] args) {
		Question46TranslateNum q46 = new Question46TranslateNum();
		System.out.println(q46.translateNum(758212932));
		System.out.println(q46.translateNumUsingDp(758212932));
	}
}
