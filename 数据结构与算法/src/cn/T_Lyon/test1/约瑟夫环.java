package cn.T_Lyon.test1;
/*
 * Լɪ������
 * ��սʱ����41����̫��ץ�ˣ�Ȼ�����������������ǣ�
 * ������Χ�ɻ����ӵ�һ����ÿ�������ı����Ͱ���ɱ����
 * ������������������ǵڼ�����
 * */

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Լɪ�� {
    private static class Node {
        int No;
        Node next;

        public Node(int No) {
            this.No = No;
        }
    }

    public static void main(String[] args) {
        while (true) {
            int totalNum, cycleNum;
            Scanner cin = new Scanner(new BufferedInputStream(System.in));
            System.out.println("��������������");
            totalNum = cin.nextInt();
            System.out.println("�����뱨��������");
            cycleNum = cin.nextInt();
            Node header = new Node(1);
            Node pointer = header;
            for (int i = 2; i <= totalNum; i++) {
                pointer.next = new Node(i);
                pointer = pointer.next;
            }
            pointer.next = header;
            pointer = header;


            while (pointer != pointer.next) {
                if (cycleNum < 0) {
                    System.out.println("�Ŷ�������Ϊ��");
                    return;
                } else if (cycleNum == 0) {
                    System.out.println("�����˶��ǰ�ȫ��");
                    return;
                } else if (cycleNum == 1) {
                    for (int i = 0; i < totalNum - 1; i++) {
                        pointer = pointer.next;
                        System.out.println("�����" + pointer.No + "�޳���");
                    }
                    pointer.next = pointer;
                } else {
                    int i = 2;
                    while (i < cycleNum) {
                        pointer = pointer.next;
                        i++;
                    }
                    System.out.println("�����" + pointer.next.No + "�޳���");
                    pointer.next = pointer.next.next;
                    pointer = pointer.next;
                }
            }
            if (cycleNum == 1) {
                System.out.println("�������һ���ˣ�" + pointer.No);
            } else if (cycleNum > 1) {
                System.out.println("�������һ���ˣ�" + pointer.No);
            }
        }
    }
}
