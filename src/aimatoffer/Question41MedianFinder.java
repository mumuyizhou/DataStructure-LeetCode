package aimatoffer;

import java.beans.beancontext.BeanContext;
import java.util.Arrays;

/**
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
		if (maxSize == 0) {
			maxHeap.add(num);
			return;};
		if (minSize == 0) {
			minorHeap.add(num);
			return;
		}
		if (minSize >= maxSize) {
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
		if (size % 2 == 0) return (double) (minorHeap.getHead() + maxHeap.getHead()) / 2;
		return maxHeap.getHead();
	}

	public static void main(String[] args) {
		Question41MedianFinder medianFinder = new Question41MedianFinder();
		medianFinder.addNum(-1);
		medianFinder.addNum(-2);
		medianFinder.addNum(-3);
		System.out.println("");
	}

}

class Heap {
	public int size;
	private static final int DEFAULT_CAPACITY = 10;
	private int[] heap;
	private boolean isMaxHeap;

	public Heap(boolean isMaxHeap) {
		this.size = 0;
		this.heap = new int[DEFAULT_CAPACITY];
		this.isMaxHeap = isMaxHeap;
	}

	private void grow() {
		int oldCapacity = heap.length;
		int newCapacity = oldCapacity + (oldCapacity >>> 1);
		Arrays.copyOf(heap, newCapacity);
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

	private void siftUp(int num, int pos) {
		while (pos > 0) {
			int p = (pos - 1) >>> 1;
			int parent = heap[p];
			if ((isMaxHeap && num <= parent) || ((!isMaxHeap) && num >= parent)) {
				heap[pos] = num;
				break;
			}
			heap[p] = num;
			heap[pos] = parent;
			pos = p;
		}
	}

	public int getHead() {
		if (size == 0) throw new IllegalArgumentException("heap is now empty!");
		return heap[0];
	}

	public void siftDown() {
		int pos = 0;
		while (pos < size) {
			int s = heap[pos];
			int left = (pos << 1) + 1;
			int right = left + 1;
			if (isMaxHeap) {
				if (left < size && right < size) {
					int maxSonPos = heap[left] > heap[right] ? left : right;
					if (s >= heap[maxSonPos]) break;
					heap[pos] = heap[maxSonPos];
					heap[maxSonPos] = s;
					pos = maxSonPos;
				}
				if (right >= size && heap[left] > heap[pos]) {
					heap[pos] = heap[left];
					heap[left] = s;
					pos = left;
				}else {
					break;
				}
			} else {
				if (right < size) {
					int maxSonPos = heap[left] < heap[right] ? left : right;
					if (s <= heap[maxSonPos]) break;
					heap[pos] = heap[maxSonPos];
					heap[maxSonPos] = s;
					pos = maxSonPos;
				}
				if (left <= size && heap[left] < heap[pos]) {
					heap[pos] = heap[left];
					heap[left] = s;
					pos = left;
				}
				else{
					break;
				}
			}
		}
	}

	public void setHead(int num) {
		heap[0] = num;
		siftDown();
	}
}

