package trees_graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

class Node {
	Node left, right, parent;
	private int key;

	public int getKey() {
		return key;
	}

	public Node(int key, Node parent) {
		this.key = key;
		this.parent = parent;
	}
}

public class BinaryTree {

	private static Node root;

	public static void main(String args[]) {
		TreeMethods tm = new TreeMethods();
		ArrayList<Integer> treeData = new ArrayList<>();
		treeData.add(25);
		treeData.add(3);
		treeData.add(4);
		treeData.add(8);
		treeData.add(46);
		treeData.add(15);
		treeData.add(18);
		treeData.add(67);
		treeData.add(59);
		treeData.add(89);
		treeData.add(91);
		treeData.add(82);
		treeData.add(83);
		root = tm.createTree(treeData);
		// tm.bsf(root);
		// tm.dsf(root);
		// tm.inorder(root);
		// tm.preorder(root);
		tm.isBipartite(root);
	}
}

class TreeMethods {

	void addNode(Node root, int data) {
		if (root.getKey() < data) {
			if (root.right == null) {
				root.right = new Node(data, root);
				return;
			}
			addNode(root.right, data);
		} else {
			if (root.left == null) {
				root.left = new Node(data, root);
				return;
			}
			addNode(root.left, data);
		}
	}

	Node createTree(ArrayList<Integer> treeData) {

		Node root = new Node(treeData.get(0), null);
		for (int i = 1; i < treeData.size(); i++) {
			addNode(root, treeData.get(i));
		}

		return root;
	}

	void inorder(Node root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.print(root.getKey() + " ");
		inorder(root.right);
	}

	void preorder(Node root) {
		if (root == null)
			return;
		System.out.print(root.getKey() + " ");
		preorder(root.left);
		preorder(root.right);

	}

	void bsf(Node root) {

		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		List<Node> ans = new ArrayList<>();
		// ans.add(root);
		while (!q.isEmpty()) {
			Node n = q.poll();
			ans.add(n);
			if (n.left != null)
				q.add(n.left);
			if (n.right != null)
				q.add(n.right);
		}
		ans.stream().map(x -> x.getKey() + " ").forEach(System.out::print);
	}

	void dsf(Node root) {
		Stack<Node> s = new Stack<>();
		List<Node> ans = new ArrayList<>();
		s.push(root);
		while (!s.isEmpty()) {
			Node n = s.pop();
			ans.add(n);
			if (n.right != null)
				s.push(n.right);
			if (n.left != null)
				s.push(n.left);
		}
		ans.stream().map(x -> x.getKey() + " ").forEach(System.out::print);
	}

	void isBipartite(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		Set<Node> red = new HashSet<>();
		Set<Node> blue = new HashSet<>();
		red.add(root);
		q.add(root);

		while (!q.isEmpty()) {
			Node n = q.poll();
			if (n.left != null) {
				q.add(n.left);
				if (red.contains(n)) {
					if (red.contains(n.left))
						return;
					blue.add(n.left);
				}
				if (blue.contains(n)) {
					if (blue.contains(n.left))
						return;
					blue.add(n.left);
				}
			}
			if (n.right != null) {
				q.add(n.right);
				if (red.contains(n)) {
					if (red.contains(n.right))
						return;
					blue.add(n.right);
				}
				if (blue.contains(n)) {
					if (blue.contains(n.right))
						return;
					blue.add(n.right);
				}
			}
		}
		System.out.println("Yes");
	}
}
