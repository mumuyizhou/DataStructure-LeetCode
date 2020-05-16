package aimatoffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，
 * 则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * 示例 1：
 * 输入: n = 5, m = 3
 * 输出: 3
 * 示例 2：
 * 输入: n = 10, m = 17
 * 输出: 2
 *  
 * 限制：
 * 1 <= n <= 10^5
 * 1 <= m <= 10^6
 *
 * @author 木木漪
 */
public class Question62YuanQuanZhongZuiHouShengXiaDeShuZi {
	public int lastRemaining(int n, int m) {
//		List<Integer> list = new ArrayList<>(n);
//		for (int i = 0; i < n; i++) {
//			list.add(i);
//		}
//		int p = 0;
//		while (list.size() > 1) {
//			p = (p + m - 1) % list.size();
//			list.remove(p);
//		}
//		return list.get(0);
		List<Integer> alist = new ArrayList<>(n);
		List<Integer> lList = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			alist.add(i);
			lList.add(i);
		}
		int p = 0;
		long time = System.currentTimeMillis();
		while (alist.size() > 1) {
			p = (p + m - 1) % alist.size();
			alist.remove(p);
		}
		System.out.println("ArrayList:"+(System.currentTimeMillis() - time) + " ms");
		p = 0;
		time = System.currentTimeMillis();
		while (lList.size() > 1) {
			p = (p + m - 1) % lList.size();
			lList.remove(p);
		}
		System.out.println("LinkedList:"+(System.currentTimeMillis() - time) + " ms");
		return alist.get(0);
	}

	/**
	 * 约瑟夫环 ，见：https://blog.csdn.net/u011500062/article/details/72855826
	 *
	 * @param n
	 * @param m
	 * @return
	 */
	public int lastRemainingJosephRing(int n, int m) {
		int p = 0;
		for (int i = 2; i <= n; i++) {
			p = (p + m) % i;
		}
		return p;
	}

	public static void main(String[] args) {
		Question62YuanQuanZhongZuiHouShengXiaDeShuZi shuZi = new Question62YuanQuanZhongZuiHouShengXiaDeShuZi();
		System.out.println(shuZi.lastRemaining(100000, 100000));
		System.out.println(shuZi.lastRemainingJosephRing(5, 3));
	}
}
