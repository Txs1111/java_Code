package cn.T_Lyon.test1;

//二叉链表
public class BTNode<E> {
	E data;				//结点的数据域
	BTNode<E> lchild;	//指向左子结点
	BTNode<E> rchild;	//指向右子结点
	boolean ltag	=false;	//false表示当前结点的lchild指向左孩子，true表示指向前驱结点   bit
	boolean rtag 	=false; //false表示当前结点的rchild指向右孩子，true表示指向后驱结点
	public BTNode() {
		super();
	}
	public BTNode(E data) {
		super();
		this.data = data;
	}
}
