

/**
 * @author ZhouPan
 * @date 2020-06-22
 */
class Solution {
	public boolean validateStackSequences(int[] pushed, int[] popped) {
		int lenPush = pushed.length;
		int push = 0;
		int pop = 0;
		int q = 0;

		while(push <  lenPush){
			if(pushed[push] == popped[q]){
				while(pushed[pop]== popped[q]){
					pop--;
					q++;
				}
				push++;
			}else {
				push++;
				pop++;
				pushed[pop] = pushed[push];
			}
		}
		return push==0;
	}
}
