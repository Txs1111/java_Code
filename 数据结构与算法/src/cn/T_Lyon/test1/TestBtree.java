package cn.T_Lyon.test1;

import java.util.ArrayList;

public class TestBtree {
	public static void main(String[] args) {
		String str="A(B(D(,G)),C(E,F))";
		BTree btree = new BTree();
		btree.createTree(str);
		
		System.out.println("先序遍历："+btree.preOrder());
		System.out.println("中序遍历："+btree.infixOrder());
		System.out.println("后序遍历："+btree.postOrder());
		System.out.println("层次遍历："+btree.levelOrder());
	}
}
