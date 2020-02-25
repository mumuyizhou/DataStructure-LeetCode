package aimatoffer;

public class Question64Qiu12lOf {
	/*求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。*/
	public int sumNums(int n) {
		return n + ((int) (Math.pow(n, 2)) - n >>> 1);
	}

	public int sumNumsUsingRecursion(int n) {
		int k = 0;
		boolean b = n > 0 && (k = n + sumNumsUsingRecursion(n - 1)) > 0;
		return k;

	}

	public static void main(String[] args) {
		Question64Qiu12lOf q64 = new Question64Qiu12lOf();
		System.out.println(q64.sumNumsUsingRecursion(10000));
	}
}
