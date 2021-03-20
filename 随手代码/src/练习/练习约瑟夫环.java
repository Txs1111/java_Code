
/*
 * ---------------------------------------------------------------
 *                     java_Code
 *                     练习约瑟夫环.java
 * T_Lyon
 * 2020/12/24 下午6:37
 * @content：重写约瑟夫环第一遍。看了几次源文档，emmm不是很行。
 * @err:已经创建节点的地方重复创建，原来是present = new Node(i);//=present.value = i;(如果不使用构造方法，则是present.value = i;)。
 *   int overall = 41;//总人数
        int number = 3;//间隔人数
        Node header = new Node(1);
//        创建头结点,其值为1
        Node present = header;
//         创建当前节点
//        创建长度为overall的链表，其值为1、2、3、4、5、6、7.....
        for (int i = 2; i <= overall; i++) {
            present.next = new Node(i);//=present.value = i;(如果不使用构造方法，则是present.value = i;)
            present = present.next;
        }
 * -----------------------------------------------------------------
 */

package 练习;

//有41个人，围成了圆○，从第一个人起，每隔三个将他挑出来，再在剩下的人中继续，直到最后一个人
/*
 * 约瑟夫环问题
 * 二战时期有41个犹太人抓了，然后军队里决定处决他们，
 * 让他们围成环，从第一个起，每数到三的倍数就把它杀掉，
 * 最后留下两个，他们是第几个？
 * */
public class 练习约瑟夫环 {
    //定义一个链表类
    //静态内部类
    static class Node {
        int value;
        Node next;

        //        创建构造方法，方便传值
        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        int overall = 41;//总人数
        int number = 3;//间隔人数
        Node header = new Node(1);
//        创建头结点,其值为1
        Node present = header;
//         创建当前节点
//        创建长度为overall的链表，其值为1、2、3、4、5、6、7.....
        for (int i = 2; i <= overall; i++) {
            present.next = new Node(i);//=present.value = i;(如果不使用构造方法，则是present.value = i;)
            present = present.next;
        }
        present.next = header;
//        定位到header链表
        present = header;
//        直到只有一个人结束
        while (present != present.next) {
            for (int i = 2; i < number; i++) {
                present = present.next;
            }
            System.out.println("挑出的是：" + present.next.value);
            present.next = present.next.next;
            present = present.next;
        }
        System.out.println("最后一个为：" + present.value);

    }
}
