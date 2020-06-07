package aimatoffer;

/**
 * @author ZhouPan
 * @date 2020-06-06
 */
public class Temp {
	public int count() {
		int n = 10000, count = 0, result = 1;
		while (n >= 1) {
			result *= n;
			n--;
			if (result % 10 == 0) {
				count++;
				result/=10;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Temp temp = new Temp();
		System.out.println(temp.count());
	}
}
