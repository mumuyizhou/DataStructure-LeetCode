package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author 木木漪
 */
public class MedianFinder {
	private int countNums = 0;
	private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> (y - x));
	private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	private int lenOfMax;

	/**
	 * initialize your data structure here.
	 */
	public MedianFinder() {

	}

	public void addNum(int num) {
		lenOfMax = (++countNums) / 2;
		if (maxHeap.size() < lenOfMax) {
			if (num > minHeap.peek()) {
				maxHeap.add(minHeap.remove());
				minHeap.add(num);
			} else {
				maxHeap.add(num);
			}
		} else {
			if (maxHeap.size() == 0) {
				minHeap.add(num);
			} else if (num < maxHeap.peek()) {
				minHeap.add(maxHeap.remove());
				maxHeap.add(num);
			} else {
				minHeap.add(num);
			}
		}
	}

	public double findMedian() {
		if (countNums == 1) {
			return minHeap.peek();
		}
		int left = maxHeap.peek();
		int right = minHeap.peek();
		return countNums % 2 == 0 ? (left + right) / 2.0 : right;
	}

	public static void main(String[] args) {
		MedianFinder obj = new MedianFinder();
		obj.addNum(1);
		obj.addNum(2);
		obj.addNum(3);
		obj.addNum(100);
		double param_2 = obj.findMedian();
		System.out.println(param_2);
		List<Integer> list = new ArrayList<>();
		list.add(1);
		System.out.println(list.get(0));
	}
}
