package aimatoffer;

import java.util.Arrays;
import java.util.Random;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 例如，
 * [2,3,4] 的中位数是 3
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * 设计一个支持以下两种操作的数据结构：
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例 1：
 * 输入：
 * ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
 * [[],[1],[2],[],[3],[]]
 * 输出：[null,null,null,1.50000,null,2.00000]
 * 示例 2：
 * 输入：
 * ["MedianFinder","addNum","findMedian","addNum","findMedian"]
 * [[],[2],[],[3],[]]
 * 输出：[null,null,2.00000,null,2.50000]
 * 限制：
 * 最多会对 addNum、findMedia进行 50000 次调用。
 *
 * @author ZhouPan
 * @date 2020-06-19
 */
public class Question41MedianFinder {
	private final Heap minorHeap; //堆顶为最小元素
	private final Heap maxHeap; //堆顶为最大元素

	/**
	 * initialize your data structure here.
	 */
	public Question41MedianFinder() {
		this.minorHeap = new Heap(false);
		this.maxHeap = new Heap(true);
	}

	public void addNum(int num) {
		//todo 输入-1,-2,-3时最大堆有-1和-3，最小堆只有-2
		int maxSize = maxHeap.size;
		int minSize = minorHeap.size;

		if (minSize >= maxSize) {
			if (maxSize == 0) {
				maxHeap.add(num);
				return;
			}
			if (num > minorHeap.getHead()) {
				maxHeap.add(minorHeap.getHead());
				minorHeap.setHead(num);
			} else {
				maxHeap.add(num);
			}
		} else {
			if (num < maxHeap.getHead()) {
				minorHeap.add(maxHeap.getHead());
				maxHeap.setHead(num);
			} else {
				minorHeap.add(num);
			}
		}
	}

	public double findMedian() {
		int size = minorHeap.size + maxHeap.size;
		if ((size & 1) == 0) return (double) (minorHeap.getHead() + maxHeap.getHead()) / 2;
		return maxHeap.getHead();
	}

	public static void main(String[] args) {
		Question41MedianFinder medianFinder = new Question41MedianFinder();
		Random random = new Random();
		for (int i = 0; i < 100; i++) {
			medianFinder.addNum(random.nextInt(100));
		}
		System.out.println("");
	}

	public class Heap {
		public int size;
		private static final int DEFAULT_CAPACITY = 10;
		private int[] heap;
		private final boolean isMaxHeap;

		public Heap(boolean isMaxHeap) {
			this.size = 0;
			this.heap = new int[DEFAULT_CAPACITY];
			this.isMaxHeap = isMaxHeap;
		}

		private void grow() {
			int oldCapacity = heap.length;
			int newCapacity = oldCapacity + (oldCapacity >>> 1);
			heap = Arrays.copyOf(heap, newCapacity);
		}

		private void ensureCapacity() {
			if (size + 1 > heap.length) {
				grow();
			}
		}

		public void add(int num) {
			ensureCapacity();
			if (size == 0) {
				heap[0] = num;
			} else {
				siftUp(num, size);
			}
			size++;
		}

		public int getHead() {
			if (size == 0)
				throw new IllegalArgumentException((isMaxHeap ? "maxHeap" : "minorHeap") + "heap is now empty!");
			return heap[0];
		}

		public void setHead(int num) {
			heap[0] = num;
			siftDown();
		}

		private void siftUp(int num, int pos) {
			heap[pos] = num;
			while (pos > 0) {
				int p = (pos - 1) >>> 1;
				int parent = heap[p];
				if ((isMaxHeap && heap[pos] <= parent) || ((!isMaxHeap) && heap[pos] >= parent)) {
					break;
				}
				heap[p] = heap[pos];
				heap[pos] = parent;
				pos = p;
			}
		}

		public void siftDown() {
			int pos = 0;
			while (pos < size) {
				int s = heap[pos];
				int left = (pos << 1) + 1;
				if (left >= size) return;
				int right = left + 1;
				if (isMaxHeap) {
					if (right < size) {
						int maxSonPos = heap[left] > heap[right] ? left : right;
						if (s >= heap[maxSonPos]) break;
						heap[pos] = heap[maxSonPos];
						heap[maxSonPos] = s;
						pos = maxSonPos;
					} else if (heap[left] > heap[pos]) {
						heap[pos] = heap[left];
						heap[left] = s;
						break;
					} else {
						break;
					}
				} else {
					if (right < size) {
						int minSonPos = heap[left] < heap[right] ? left : right;
						if (s <= heap[minSonPos]) break;
						heap[pos] = heap[minSonPos];
						heap[minSonPos] = s;
						pos = minSonPos;
					} else if (heap[left] < heap[pos]) {
						heap[pos] = heap[left];
						heap[left] = s;
						break;
					} else {
						break;
					}
				}
			}
		}
	}
}



