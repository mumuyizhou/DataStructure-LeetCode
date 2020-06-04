package aimatoffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * 示例:
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:  
 * 1 是丑数。
 * n 不超过1690。
 *
 * @author ZhouPan
 * @date 2020-06-03
 */
public class Question49UglyNumber {
	public int nthUglyNumber(int n) {
		List<Boolean> lookUpList = new ArrayList<>(1690);
		lookUpList.add(false);
		lookUpList.add(true);
		lookUpList.add(true);
		lookUpList.add(true);
		lookUpList.add(true);
		lookUpList.add(true);

		int count = 0;
		int p = 6;
		while (true) {
			if (isUgly(p, lookUpList)) count++;
			if (count == n) return p;
			p++;
		}
	}

	public boolean isUgly(int num, List<Boolean> lookUpList) {
//		if (num == 1 || num == 2 || num == 3 || num == 5) {
//			if (lookUpList.size() <= num) {
//				lookUpList.add(true);
//			}
//			return true;
//		}
		if (num < lookUpList.size()) return lookUpList.get(num);
		boolean currentIsUgly = false;
		if (num % 2 == 0) {
			currentIsUgly = lookUpList.get(num / 2);
		}
		if (num % 3 == 0) {
			currentIsUgly = currentIsUgly || lookUpList.get(num / 3);
		}
		if (num % 5 == 0) {
			currentIsUgly = currentIsUgly || lookUpList.get(num / 5);
		}
		lookUpList.add(currentIsUgly);
		return currentIsUgly;
	}

	/**
	 * 三指针法。
	 * 我们知道，丑数的排列肯定是1,2,3,4,5,6,8,10.... 然后有一个特点是，任意一个丑数都是由小于它的某一个丑数*2，*3或者*5得到的，
	 * 那么如何得到所有丑数呢？ 现在假设有3个数组，分别是： A：{1*2，2*2，3*2，4*2，5*2，6*2，8*2，10*2......}
	 * B：{1*3，2*3，3*3，4*3，5*3，6*3，8*3，10*3......}
	 * C：{1*5，2*5，3*5，4*5，5*5，6*5，8*5，10*5......}
	 * 那么所有丑数的排列，必定就是上面ABC3个数组的合并结果然后去重得到的，那么这不就转换成了三个有序数组的无重复元素合并的问题了吗？
	 * 而这三个数组就刚好是{1,2,3,4,5,6,8,10....}乘以2,3,5得到的。
	 * 合并有序数组的一个比较好的方法，就是每个数组都对应一个指针，然后比较这些指针所指的数中哪个最小，就将这个数放到结果数组中，然后该指针向后挪一位。
	 * 回到本题，要求丑数ugly数组中的第n项，而目前只知道ugly[0]=1，所以此时三个有序链表分别就只有一个元素：
	 * A ： {1*2......}
	 * B ： {1*3......}
	 * C ：{1*5......}
	 * 假设三个数组的指针分别是i,j,k，此时均是指向第一个元素，然后比较A[i]，B[j]和C[k]，得到的最小的数A[i]，
	 * 就是ugly[1]，此时ugly就变成{1,2}了，对应的ABC数组就分别变成了：
	 * A ： {1*2，2*2......}
	 * B ： {1*3, 2*3......}
	 * C ：{1*5,2*5......}
	 * 此时根据合并有序数组的原理，A数组指针i就指向了下一个元素，即'2*2'，而j和k依然分别指向B[0]和C[0]，然后进行下一轮合并，
	 * 就是A[1]和B[0]和C[0]比较，最小值作为ugly[2].....如此循环n次，就可以得到ugly[n]了。
	 * 此外，注意到ABC三个数组实际上就是ugly[]*2，ugly[]*3和ugly[]*5的结果，
	 * 所以每次只需要比较A[i]=ugly[i]*2，B[j]=ugly[j]*3和C[k]=ugly[k]*5的大小即可。然后谁最小，就把对应的指针往后移动一个，
	 * 为了去重，如果多个元素都是最小，那么这多个指针都要往后移动一个。
	 *
	 * @param n
	 * @return
	 */
	public int nthUglyNumberThreePointers(int n) {
		if (0 == n) return 0;
		int[] uglyNums = new int[n];
		uglyNums[0] = 1;
		int p2 = 0, p3 = 0, p5 = 0, pUgly = 0;
		while (pUgly < n - 1) {
			int tmp = Math.min(Math.min(uglyNums[p2] * 2, uglyNums[p3] * 3),
					uglyNums[p5] * 5);
			if (tmp == uglyNums[p2] * 2) p2++;
			if (tmp == uglyNums[p3] * 3) p3++;
			if (tmp == uglyNums[p5] * 5) p5++;
			uglyNums[++pUgly] = tmp;
		}
		return uglyNums[n - 1];
	}

	public static void main(String[] args) {
		Question49UglyNumber uglyNumber = new Question49UglyNumber();
		long current = System.currentTimeMillis();
		uglyNumber.nthUglyNumber(1000);
		System.out.println(System.currentTimeMillis() - current);
	}

}
