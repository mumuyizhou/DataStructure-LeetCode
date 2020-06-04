package aimatoffer;

/**
 * @author ZhouPan
 * @date 2020-06-04
 */
public class Question67TransformStrToInt {
	public int strToInt(String str) {
		str = str;
	}

	public String trim(String s) {
		int pl = 0, pr = 0, len = s.length();
		for (int i = 0; i < len; i++) {
			if (s.charAt(i) != ' ') break;
			pl++;
		}
		for (int i = pl; i < len; i++) {
			if(s.charAt(i) == ' ') break;
			pr++;
		}

	}
}
