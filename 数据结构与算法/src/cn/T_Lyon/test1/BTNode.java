package cn.T_Lyon.test1;

//��������
public class BTNode<E> {
	E data;				//����������
	BTNode<E> lchild;	//ָ�����ӽ��
	BTNode<E> rchild;	//ָ�����ӽ��
	boolean ltag	=false;	//false��ʾ��ǰ����lchildָ�����ӣ�true��ʾָ��ǰ�����   bit
	boolean rtag 	=false; //false��ʾ��ǰ����rchildָ���Һ��ӣ�true��ʾָ��������
	public BTNode() {
		super();
	}
	public BTNode(E data) {
		super();
		this.data = data;
	}
}
