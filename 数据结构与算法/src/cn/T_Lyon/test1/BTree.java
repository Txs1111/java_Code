package cn.T_Lyon.test1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//通过包含括号表达的树的逻辑结构的字符串，创建一个字符二叉树
public class BTree {
	String str;	//
	BTNode<Character> root;				//二叉树的根结点
	
	//str为括号表示法的树的表达方式，构造成一个二叉链式二叉树
	//如：A(B(D(,G)),C(E,F))
	public void createTree(String str){
		BTNode<Character> p =null;		//每个字母要构造成树的一个结点
		boolean isLeft =true;			//通过括号或,来确定下一个结点为上一个结点的左或右子结点
		int i=0;						//通过i来表示字符串的索引号，依次从0开始读串中的每个字符
		Stack<BTNode<Character>> stack = new Stack<>();		//栈保存树的结点
		while(i<str.length()){
			Character ch = str.charAt(i);		//取出串中第i个字符
			switch (ch) {
			case '(':					//表示上一个结点有子结点
				isLeft=true;
				stack.push(p);		//把上一个节点入栈
				break;
			case ')':
				stack.pop();		//表示栈顶结点左右子结点处理完
				break;
			case ',':
				isLeft =false;		//表示下一个结点为右子结点
				break;
			default:
				p= new BTNode<Character>(ch);
				if(root==null){
					root=p;
				}else{
					if(isLeft){		//表示当前结点应该为栈顶元素的左子结点
						if(!stack.isEmpty())
							stack.peek().lchild=p;	//让栈顶结点的左子结点指向当前结点
					}else{
						if(!stack.isEmpty())
							stack.peek().rchild=p;	//让栈顶结点的右子结点指向当前结点
					}
				}
				break;
			}
			i++;		//索引号递增
		}
	}
	//前序遍历,根左右,node为要遍历的树/子树的根结点
	public void preOrder(BTNode node,ArrayList list){
		if(node==null) return;
		list.add(node.data);			//取根结点
		preOrder(node.lchild, list);	//左子树也前序遍历
		preOrder(node.rchild, list);	//右子树也前序遍历
	}
	//从根结点开始调用递归前序遍历
	public ArrayList preOrder(){
		ArrayList list = new ArrayList<>();
		preOrder(root,list);
		return list;
	}
	//中序
	public void infixOrder(BTNode node,ArrayList list){
		if(node==null) return;
		infixOrder(node.lchild, list);	//左子树也前序遍历
		list.add(node.data);			//取根结点
		infixOrder(node.rchild, list);	//右子树也前序遍历
	}
	public ArrayList infixOrder(){
		ArrayList list = new ArrayList<>();
		infixOrder(root,list);
		return list;
	
	}
	//后序
	public void postOrder(BTNode node,ArrayList list){
		if(node==null) return;
		postOrder(node.lchild, list);	//左子树也前序遍历
		postOrder(node.rchild, list);	//右子树也前序遍历
		list.add(node.data);			//取根结点
		
	}
	public ArrayList postOrder(){
		ArrayList list = new ArrayList<>();
		postOrder(root,list);
		return list;
	}
	
	//层次遍历
	public ArrayList levelOrder(){
		ArrayList list = new ArrayList<>();
		Queue<BTNode> queue = new LinkedList<BTNode>();		//LinkedList实现Queue接口的类
		queue.offer(root);									//将根结点入队
		while(!queue.isEmpty()){
			BTNode p = queue.poll();						//从队中出一个结点，用p变量保存
			list.add(p.data);
			if(p.lchild!=null){
				queue.offer(p.lchild);						//如果刚出队的结点有左孩子，将左孩子入队
			}
			if(p.rchild!=null){
				queue.offer(p.rchild);						//如果刚出队的结点有右孩子，将右孩子入队
			}
		}
		return list;
	}

}
