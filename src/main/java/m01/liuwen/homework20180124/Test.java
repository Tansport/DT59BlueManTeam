/**
 * Project Name:DT59BlueManTeam
 * File Name:Test.java
 * Package Name:m01.liuwen.homework20180124
 * Date:2018年1月24日下午10:47:57
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.liuwen.homework20180124;

import java.util.ArrayList;

/**
 * Description:   <br/>
 * Date:     2018年1月24日 下午10:47:57 <br/>
 * @author   WEN LIU
 * @version
 * @see
 */
/**
 * List<HashMap<Integer,Person>> 集合中嵌套集合，如何遍历？ <br>
 * 北大青鸟光谷校区 <br>
 * 每个班级的学生 ArrayList<Student> <br>
 * 学校里面多个班 ArrayList<ArrayList<Student>>
 */
public class Test {

    public static void main(String[] args) {
        // 1.创建大的集合
        ArrayList<ArrayList<Student>> bigList = new ArrayList<ArrayList<Student>>();

        // 2.创建第一个班级的学生
        ArrayList<Student> list1 = new ArrayList<Student>();
        list1.add(new Student(10, "勇敢1号"));
        list1.add(new Student(20, "勇敢2号"));
        list1.add(new Student(30, "勇敢3号"));
        list1.add(new Student(40, "勇敢4号"));

        // 3.将班级1添加到大集合中
        bigList.add(list1);

        // 4.创建第二个班级的学生
        ArrayList<Student> list2 = new ArrayList<Student>();
        list2.add(new Student(12, "牛批1号"));
        list2.add(new Student(22, "牛批2号"));
        list2.add(new Student(32, "牛批3号"));
        list2.add(new Student(42, "牛批4号"));

        // 5.将班级二添加到大集合中
        bigList.add(list2);

        // 6.遍历的大集合
        int number = 59;
        for (int i = 0; i < bigList.size(); i++) {// 外层循环线找到班级
            System.out.println("班级号为： " + number);
            for (int j = 0; j < bigList.get(i).size(); j++) {
                Student s = bigList.get(i).get(j);
                System.out.println(s.toString());
            }
            number++;
        }
    }

}

class Student {
    private int id;

    private String name;

    public Student() {
        super();
    }

    public Student(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + "]";
    }

}
