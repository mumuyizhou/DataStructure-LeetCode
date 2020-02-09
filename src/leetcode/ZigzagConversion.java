package leetcode;

import java.util.ArrayList;

/**
 * @author 木木漪
 */
public class ZigzagConversion {
	public String convert(String s, int numRows) {
		if (numRows == 1) {
			return s;
		}
		int[] flag = new int[2 * (numRows - 1)];
		for (int i = 0; i < flag.length; i++) {
			if (i < numRows) {
				flag[i] = i + 1;
			} else {
				flag[i] = flag.length - i + 1;
			}
		}

		StringBuilder sb = new StringBuilder(s.length());
		ArrayList<StringBuilder> rowBuilderList = new ArrayList<>(numRows);
		for (int i = 0; i < numRows; i++) {
			rowBuilderList.add(new StringBuilder());
		}
		for (int i = 0; i < s.length(); i++) {
			int pos = (i + 1) % flag.length;
			if (pos == 0) pos += flag.length;
			rowBuilderList.get(flag[pos-1]-1).append(s.charAt(i));
		}
		rowBuilderList.stream().forEach(rowBuilder->sb.append(rowBuilder));
		return sb.toString();
	}

	public static void main(String[] args) {
		ZigzagConversion zig = new ZigzagConversion();
		zig.convert("LEETCODEISHIRING", 4);
	}
}
