package cn.T_Lyon.test1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//ͨ���������ű��������߼��ṹ���ַ���������һ���ַ�������
public class BTree {
	String str;	//
	BTNode<Character> root;				//�������ĸ����
	
	//strΪ���ű�ʾ�������ı�﷽ʽ�������һ��������ʽ������
	//�磺A(B(D(,G)),C(E,F))
	public void createTree(String str){
		BTNode<Character> p =null;		//ÿ����ĸҪ���������һ�����
		boolean isLeft =true;			//ͨ�����Ż�,��ȷ����һ�����Ϊ��һ������������ӽ��
		int i=0;						//ͨ��i����ʾ�ַ����������ţ����δ�0��ʼ�����е�ÿ���ַ�
		Stack<BTNode<Character>> stack = new Stack<>();		//ջ�������Ľ��
		while(i<str.length()){
			Character ch = str.charAt(i);		//ȡ�����е�i���ַ�
			switch (ch) {
			case '(':					//��ʾ��һ��������ӽ��
				isLeft=true;
				stack.push(p);		//����һ���ڵ���ջ
				break;
			case ')':
				stack.pop();		//��ʾջ����������ӽ�㴦����
				break;
			case ',':
				isLeft =false;		//��ʾ��һ�����Ϊ���ӽ��
				break;
			default:
				p= new BTNode<Character>(ch);
				if(root==null){
					root=p;
				}else{
					if(isLeft){		//��ʾ��ǰ���Ӧ��Ϊջ��Ԫ�ص����ӽ��
						if(!stack.isEmpty())
							stack.peek().lchild=p;	//��ջ���������ӽ��ָ��ǰ���
					}else{
						if(!stack.isEmpty())
							stack.peek().rchild=p;	//��ջ���������ӽ��ָ��ǰ���
					}
				}
				break;
			}
			i++;		//�����ŵ���
		}
	}
	//ǰ�����,������,nodeΪҪ��������/�����ĸ����
	public void preOrder(BTNode node,ArrayList list){
		if(node==null) return;
		list.add(node.data);			//ȡ�����
		preOrder(node.lchild, list);	//������Ҳǰ�����
		preOrder(node.rchild, list);	//������Ҳǰ�����
	}
	//�Ӹ���㿪ʼ���õݹ�ǰ�����
	public ArrayList preOrder(){
		ArrayList list = new ArrayList<>();
		preOrder(root,list);
		return list;
	}
	//����
	public void infixOrder(BTNode node,ArrayList list){
		if(node==null) return;
		infixOrder(node.lchild, list);	//������Ҳǰ�����
		list.add(node.data);			//ȡ�����
		infixOrder(node.rchild, list);	//������Ҳǰ�����
	}
	public ArrayList infixOrder(){
		ArrayList list = new ArrayList<>();
		infixOrder(root,list);
		return list;
	
	}
	//����
	public void postOrder(BTNode node,ArrayList list){
		if(node==null) return;
		postOrder(node.lchild, list);	//������Ҳǰ�����
		postOrder(node.rchild, list);	//������Ҳǰ�����
		list.add(node.data);			//ȡ�����
		
	}
	public ArrayList postOrder(){
		ArrayList list = new ArrayList<>();
		postOrder(root,list);
		return list;
	}
	
	//��α���
	public ArrayList levelOrder(){
		ArrayList list = new ArrayList<>();
		Queue<BTNode> queue = new LinkedList<BTNode>();		//LinkedListʵ��Queue�ӿڵ���
		queue.offer(root);									//����������
		while(!queue.isEmpty()){
			BTNode p = queue.poll();						//�Ӷ��г�һ����㣬��p��������
			list.add(p.data);
			if(p.lchild!=null){
				queue.offer(p.lchild);						//����ճ��ӵĽ�������ӣ����������
			}
			if(p.rchild!=null){
				queue.offer(p.rchild);						//����ճ��ӵĽ�����Һ��ӣ����Һ������
			}
		}
		return list;
	}

}
