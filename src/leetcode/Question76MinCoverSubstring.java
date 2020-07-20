package leetcode;

/**
 * @author ZhouPan
 * @date 2020-07-07
 */
public class Question76MinCoverSubstring {
	public String minWindow(String s, String t) {
		String ans = "";
		int lent, lens, pl = 0, pr = 0, needcnt;
		int[] ind = new int[128], window = new int[128];
		if (s == null || t == null || t.equals("") || s.equals("") ||
				(needcnt = lent = t.length()) > (lens = s.length())) return ans;
		for (int i = 0; i < lent; i++) {
			ind[t.charAt(i)]++;
		}
		int start = 0, end = Integer.MAX_VALUE;
		while (pr < lens) {
			char cur = s.charAt(pr);
			if (ind[cur] > 0 && ind[cur] >= ++window[cur]) needcnt--;
			while (needcnt == 0){
				char lchar = s.charAt(pl);
				if(pr - pl < end - start){
					end = pr;
					start = pl;
				}
				pl++;
				if (ind[lchar] > 0 && --window[lchar] < ind[lchar]) needcnt++;
			}
			pr++;
		}
		return s.substring(start, end + 1);
	}

	public static void main(String[] args) {
		Question76MinCoverSubstring minCoverSubstring = new Question76MinCoverSubstring();
		System.out.println(minCoverSubstring.minWindow("ADOBECODEBANC", "ABC"));
	}
}
