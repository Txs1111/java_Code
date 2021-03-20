package cn.T_Lyon.test1;

import java.util.ArrayList;

public class TestBtree {
	public static void main(String[] args) {
		String str="A(B(D(,G)),C(E,F))";
		BTree btree = new BTree();
		btree.createTree(str);
		
		System.out.println("���������"+btree.preOrder());
		System.out.println("���������"+btree.infixOrder());
		System.out.println("���������"+btree.postOrder());
		System.out.println("��α�����"+btree.levelOrder());
	}
}
