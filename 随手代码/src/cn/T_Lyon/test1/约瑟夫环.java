package cn.T_Lyon.test1;
/*
 * 约瑟夫环问题
 * 二战时期有41个犹太人抓了，然后军队里决定处决他们，
 * 让他们围成环，从第一个起，每数到三的倍数就把它杀掉，
 * 最后留下两个，他们是第几个？
 * */

import java.io.BufferedInputStream;
import java.util.Scanner;

public class 约瑟夫环 {
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
            System.out.println("请输入总人数：");
            totalNum = cin.nextInt();
            System.out.println("请输入报数人数：");
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
                    System.out.println("排队数不能为负");
                    return;
                } else if (cycleNum == 0) {
                    System.out.println("所有人都是安全的");
                    return;
                } else if (cycleNum == 1) {
                    for (int i = 0; i < totalNum - 1; i++) {
                        pointer = pointer.next;
                        System.out.println("将序号" + pointer.No + "剔除。");
                    }
                    pointer.next = pointer;
                } else {
                    int i = 2;
                    while (i < cycleNum) {
                        pointer = pointer.next;
                        i++;
                    }
                    System.out.println("将序号" + pointer.next.No + "剔除。");
                    pointer.next = pointer.next.next;
                    pointer = pointer.next;
                }
            }
            if (cycleNum == 1) {
                System.out.println("这是最后一个人：" + pointer.No);
            } else if (cycleNum > 1) {
                System.out.println("这是最后一个人：" + pointer.No);
            }
        }
    }
}
