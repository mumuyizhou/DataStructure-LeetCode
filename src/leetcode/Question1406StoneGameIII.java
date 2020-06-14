package leetcode;

/**
 * Alice 和 Bob 用几堆石子在做游戏。几堆石子排成一行，每堆石子都对应一个得分，由数组 stoneValue 给出。
 * Alice 和 Bob 轮流取石子，Alice 总是先开始。在每个玩家的回合中，该玩家可以拿走剩下石子中的的前 1、2 或 3 堆石子 。比赛一直持续到所有石头都被拿走。
 * 每个玩家的最终得分为他所拿到的每堆石子的对应得分之和。每个玩家的初始分数都是 0 。比赛的目标是决出最高分，得分最高的选手将会赢得比赛，比赛也可能会出现平局。
 * 假设 Alice 和 Bob 都采取 最优策略 。如果 Alice 赢了就返回 "Alice" ，Bob 赢了就返回 "Bob"，平局（分数相同）返回 "Tie" 。
 * 示例 1：
 * 输入：values = [1,2,3,7]
 * 输出："Bob"
 * 解释：Alice 总是会输，她的最佳选择是拿走前三堆，得分变成 6 。但是 Bob 的得分为 7，Bob 获胜。
 * 示例 2：
 * 输入：values = [1,2,3,-9]
 * 输出："Alice"
 * 解释：Alice 要想获胜就必须在第一个回合拿走前三堆石子，给 Bob 留下负分。
 * 如果 Alice 只拿走第一堆，那么她的得分为 1，接下来 Bob 拿走第二、三堆，得分为 5 。之后 Alice 只能拿到分数 -9 的石子堆，输掉比赛。
 * 如果 Alice 拿走前两堆，那么她的得分为 3，接下来 Bob 拿走第三堆，得分为 3 。之后 Alice 只能拿到分数 -9 的石子堆，同样会输掉比赛。
 * 注意，他们都应该采取 最优策略 ，所以在这里 Alice 将选择能够使她获胜的方案。
 * 示例 3：
 * 输入：values = [1,2,3,6]
 * 输出："Tie"
 * 解释：Alice 无法赢得比赛。如果她决定选择前三堆，她可以以平局结束比赛，否则她就会输。
 * 示例 4：
 * 输入：values = [1,2,3,-1,-2,-3,7]
 * 输出："Alice"
 * 示例 5：
 * 输入：values = [-1,-2,-3]
 * 输出："Tie"
 * 提示：
 * 1 <= values.length <= 50000
 * -1000 <= values[i] <= 1000
 *
 * @author ZhouPan
 * @date 2020-06-14
 */
public class Question1406StoneGameIII {
	/**
	 * 其实这是 Alice 一个人的精分游戏，你老想着有两个人在博弈就会很难下手。
	 * 一开始，Alice 面临取1、2、3 堆的抉择，Alice 此刻总共能拿多少分，取决于取完 1 or 2 or 3
	 * 堆之后面对剩下的这堆石子精分出来的 Bob能拿多少分，因为剩下的分就是 Alice 的。
	 * 也就是 dp[i]=Max(sum-dp[i+1],sum-dp[i+2],sum-dp[i+3])，
	 * dp[i]为石碓 i……n 得最高分数，sum 为 i……n 的石碓分数之和。
	 * 那 Alice 的得分即为：dp[0] ，Bob 得分为 sumAll-dp[0]。
	 * 这其实是个非常简单的动规。
	 * 平时我们写的大多数 dp 都是 0 到 n，这里是 n 到 0，可能会有些不习惯。
	 * 有童鞋还是想不清为啥明明两个人，可以用一个 dp[] 解决。你这样想，dp 代表的不是人，而代表的是那个最优策略。
	 * 作者：orangex
	 * 链接：https://leetcode-cn.com/problems/stone-game-iii/solution/shi-zi-you-xi-3jing-shen-fen-lie-ji-ke-by-orangex/
	 * 来源：力扣（LeetCode）
	 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
	 */
	public String stoneGameIII(int[] stoneValue) {
		int len = stoneValue.length;
		int sum = 0;
		int[] dp = new int[len + 1];
		dp[len]  = 0;
		for (int i = len - 1; i >= 0; i--) {
			dp[i] = Integer.MIN_VALUE;
			sum += stoneValue[i];
			for (int j = i + 1; j <= i + 3 && j <= len; j++) {
				dp[i] = Math.max(dp[i], sum - dp[j]);
			}
		}
		if (dp[0] > sum - dp[0]) return "Alice";
		else if (dp[0] == sum - dp[0]) return "Tie";
		return "Bob";
	}

	public static void main(String[] args) {
		Question1406StoneGameIII stoneGame = new Question1406StoneGameIII();
		System.out.println(stoneGame.stoneGameIII(new int[]{1, 2, 3, 7}));
	}
}
