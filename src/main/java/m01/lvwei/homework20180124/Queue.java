/**
 * Project Name:workspace1
 * File Name:link.java
 * Package Name:lession180124
 * Date:2018��1��24������7:31:14
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.lvwei.homework20180124;

import java.util.LinkedList;

/**
 * Description: <br/>
 * Date: 2018��1��24�� ����7:31:14 <br/>
 * 
 * @author lvwei
 * @version
 * @see
 */
public class Queue {

    public static void main(String[] args) {

        // Auto-generated method stub
        LinkedList<Character> link = new LinkedList<Character>();
        link.add('A');
        link.add('B');
        link.add('C');
        for (Object obj : link) {
            System.out.println(obj);
        }
        link.removeFirst();
        link.removeLast();
        link.addFirst('C');
        link.addLast('A');
        System.out.println(link);

    }
}
