package leetcode;

import java.io.*;

/**
 * @author ZhouPan
 * @date 2020-07-03
 */
public class Question38CountAndSay {
	public String countAndSay(int n) {
		String des = "1";
		StringBuilder builder = new StringBuilder(n * n);
		for (int i = 2; i <= n; i++) {
			int desLen = des.length();
			char prev = des.charAt(0);
			int cnt = 0;
			for (int j = 0; j < desLen; j++) {
				char cur = des.charAt(j);
				if (cur != prev) {
					builder.append(cnt);
					builder.append(prev);
					prev = cur;
					cnt = 1;
				} else if (j < desLen - 1) {
					cnt++;
				} else {
					builder.append(++cnt);
					builder.append(cur);
				}
			}
			des = builder.toString();
			System.out.println("n=" + n + " des =" + des);
			builder.replace(0, builder.length(), "");
		}
		return des;
	}

	public static void main(String[] args) {

		Question38CountAndSay countAndSay = new Question38CountAndSay();
		System.out.println(countAndSay.countAndSay(4));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
