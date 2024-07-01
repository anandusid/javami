package com.example.JOB4;

import java.util.ArrayList;
import java.util.List;

class Node {
	String content;
	List<Node> children;

	public Node(final String content) {
		this.content = content;
		this.children = new ArrayList<>();
	}

	public void addChild(final Node child) {
		children.add(child);
	}

	public List<Node> getChildren() {
		return children;
	}
}

public class TestJob {

	public static void main(final String[] args) {
		final Node root = new Node("A");
		final Node child1 = new Node("B");
		final Node child2 = new Node("C");
		final Node child3 = new Node("D");
		final Node child4 = new Node("E");

		root.addChild(child1);
		root.addChild(child2);
		child1.addChild(child3);
		child2.addChild(child4);

		printTree(root, 0);
	}

	public static void printTree(final Node node, final int level) {
		if (node == null) {
			return;
		}

		for (int i = 0; i < level; i++) {
			System.out.print("    ");
		}

		System.out.println("-> " + node.content);

		for (final Node child : node.getChildren()) {
			printTree(child, level + 1);
		}
	}
}
