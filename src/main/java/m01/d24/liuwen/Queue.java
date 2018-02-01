/**
 * Project Name:DT59BlueManTeam
 * File Name:Queue.java
 * Package Name:m01.liuwen.homework20180124
 * Date:2018年1月24日下午7:24:35
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d24.liuwen;

import java.util.LinkedList;

/**
 * Description: <br/>
 * Date: 2018年1月24日 下午7:24:35 <br/>
 * 
 * @author WEN LIU
 * @version
 * @see
 */
public class Queue {
    LinkedList<String> list = new LinkedList<String>();

    public void add(String str) {
        list.addFirst(str);
    }

    public String get() {
        return list.removeLast();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.add("A");
        queue.add("B");
        queue.add("C");

        System.out.println("队列的结果为：");

        while (!queue.isEmpty()) {
            System.out.print(queue.get() + "\t");
        }
    }
}
