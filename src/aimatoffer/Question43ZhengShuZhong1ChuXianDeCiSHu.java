package aimatoffer;

/**
 * @author ZhouPan
 * @date 2020-05-25
 */
public class Question43ZhengShuZhong1ChuXianDeCiSHu {
	public int countDigitOne(int n) {
		String nstr = String.valueOf(n);
		int length = nstr.length();
		int countOne = 0;
		int high, low, cur;
		for (int i = 0; i < length; i++) {
			high = "".equals(nstr.substring(0, i)) ?
					0 : Integer.parseInt(nstr.substring(0, i));
			cur = nstr.charAt(i) - '0';
			low = "".equals(nstr.substring(i + 1, length)) ?
					0 : Integer.parseInt(nstr.substring(i + 1, length));
			int order = (int) Math.pow(10, length - i - 1);
			if (cur == 0) {
				countOne += high * order;
			} else if (cur == 1) {
				countOne += high * order + low + 1;
			} else {
				countOne += (high + 1) * order;
			}
		}
		return countOne;
	}

	public static void main(String[] args) {
		Question43ZhengShuZhong1ChuXianDeCiSHu hu = new Question43ZhengShuZhong1ChuXianDeCiSHu();
		System.out.println(hu.countDigitOne(13));
	}
}
