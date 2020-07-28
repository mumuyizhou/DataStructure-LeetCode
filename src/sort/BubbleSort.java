package sort;

/**
 * @author ZhouPan
 * @date 2020-07-24
 */
public class BubbleSort {
	public void bubbleSort(int[] nums) {
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if(nums[i] > nums[j]){
					nums[i] = nums[j] + (nums[j] = nums[i]) - nums[j];
				}
			}
		}
	}

	public static void main(String[] args) {

	}


}
