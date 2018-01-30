/**
 * Project Name:lession1
 * File Name:DemoLink.java
 * Package Name:lession18
 * Date:2018年1月24日下午7:30:53
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.zhangxingyu.homework20180125;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Description: <br/>
 * Date: 2018年1月24日 下午7:30:53 <br/>
 * 
 * @author zhangxingyu
 * @version
 * @see 创建一个类Queue，代表队列（特点：先进先出），添加add(Object obj)及get（）方法，并添加main（）方法进行效果验证。提示
 *      : linkedlist addfirst
 */
public class Queue {
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList link = new LinkedList();
        System.out.println("请输入3个元素：");
        for (int i = 0; i < 3; i++) {
            String str = sc.next();
            link.add(str);
        }
        System.out.println(link);
        System.out.println("从头插入一个元素：");
        String str = sc.next();
        link.addFirst(str);
        link.removeLast();
        System.out.println(link);
        sc.close();
    }
}
