package leetcode;

import java.util.*;

/**
 * @author ZhouPan
 * @date 2020-07-28
 */
public class Question207Courses {
	//	public boolean canFinish(int numCourses, int[][] prerequisites) {
//		Node[] courseNodes = new Node[numCourses];
//		for (int[] aPair : prerequisites) {
//			if (courseNodes[aPair[0]] == null) {
//				courseNodes[aPair[0]] = new Node(aPair[0]);
//			}
//			if (courseNodes[aPair[1]] == null) {
//				courseNodes[aPair[1]] = new Node(aPair[1]);
//			}
//			courseNodes[aPair[1]].successors.add(courseNodes[aPair[0]]);
//			// if(searchLoop(courseNodes[aPair[1]], courseNodes[aPair[0]]))
//			//     return false;
//		}
//
//		for (Node node : courseNodes) {
//			if (node == null) continue;
//			for (Node next : node.successors) {
//				node.searched = true;
//				if (searchLoop(next)) return false;
//				node.searched = false;
//			}
//		}
//		return true;
//	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[] indegrees = new int[numCourses];
		List<List<Integer>> adjancency = new ArrayList<>(numCourses);
		for (int i = 0; i < numCourses; i++) {
			adjancency.add(new ArrayList<>());
		}
		Queue<Integer> queue = new ArrayDeque<>();
		for (int[] pair : prerequisites) {
			indegrees[pair[0]]++;
			adjancency.get(pair[1]).add(pair[0]);
		}

		for (int cur : indegrees) {
			if (cur == 0) queue.add(cur);
		}
		return true;
	}


	public boolean searchLoop(Node cur) {
		for (Node node : cur.successors) {
			if (node.searched) return true;
			node.searched = true;
			if (searchLoop(node)) return true;
			node.searched = false;
		}
		return false;
	}

	public static void main(String[] args) {
		Question207Courses question207Courses = new Question207Courses();
		System.out.println(question207Courses.canFinish(4, new int[][]{{2, 0}, {1, 0}, {3, 1}, {3, 2}, {1, 3}}));
	}

	class Node {
		int course;
		boolean searched = false;
		HashSet<Node> successors;
		TreeMap<Node, Object> map = new TreeMap<>(Comparator.comparingInt(o -> o.course));

		public Node(int course) {
			map.put(new Node(1), null);

			this.course = course;
			this.successors = new HashSet<>();
		}
	}
}


