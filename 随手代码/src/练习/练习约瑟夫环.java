
/*
 * ---------------------------------------------------------------
 *                     java_Code
 *                     ��ϰԼɪ��.java
 * T_Lyon
 * 2020/12/24 ����6:37
 * @content����дԼɪ�򻷵�һ�顣���˼���Դ�ĵ���emmm���Ǻ��С�
 * @err:�Ѿ������ڵ�ĵط��ظ�������ԭ����present = new Node(i);//=present.value = i;(�����ʹ�ù��췽��������present.value = i;)��
 *   int overall = 41;//������
        int number = 3;//�������
        Node header = new Node(1);
//        ����ͷ���,��ֵΪ1
        Node present = header;
//         ������ǰ�ڵ�
//        ��������Ϊoverall��������ֵΪ1��2��3��4��5��6��7.....
        for (int i = 2; i <= overall; i++) {
            present.next = new Node(i);//=present.value = i;(�����ʹ�ù��췽��������present.value = i;)
            present = present.next;
        }
 * -----------------------------------------------------------------
 */

package ��ϰ;

//��41���ˣ�Χ����Բ�𣬴ӵ�һ������ÿ����������������������ʣ�µ����м�����ֱ�����һ����
/*
 * Լɪ������
 * ��սʱ����41����̫��ץ�ˣ�Ȼ�����������������ǣ�
 * ������Χ�ɻ����ӵ�һ����ÿ�������ı����Ͱ���ɱ����
 * ������������������ǵڼ�����
 * */
public class ��ϰԼɪ�� {
    //����һ��������
    //��̬�ڲ���
    static class Node {
        int value;
        Node next;

        //        �������췽�������㴫ֵ
        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        int overall = 41;//������
        int number = 3;//�������
        Node header = new Node(1);
//        ����ͷ���,��ֵΪ1
        Node present = header;
//         ������ǰ�ڵ�
//        ��������Ϊoverall��������ֵΪ1��2��3��4��5��6��7.....
        for (int i = 2; i <= overall; i++) {
            present.next = new Node(i);//=present.value = i;(�����ʹ�ù��췽��������present.value = i;)
            present = present.next;
        }
        present.next = header;
//        ��λ��header����
        present = header;
//        ֱ��ֻ��һ���˽���
        while (present != present.next) {
            for (int i = 2; i < number; i++) {
                present = present.next;
            }
            System.out.println("�������ǣ�" + present.next.value);
            present.next = present.next.next;
            present = present.next;
        }
        System.out.println("���һ��Ϊ��" + present.value);

    }
}
