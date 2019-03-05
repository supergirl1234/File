package com;

import java.io.*;

/**
 * Author:Fanleilei
 * Created:2019/3/5 0005
 */
public class TestSerializable {

    public static void code1() {
        //1.准备序列化输出的文件
        //2.准备要参与的序列化对象
        //3.业务操作（Object->byte[]）

        File file=new File("D:"+File.separator+"javatxt"+File.separator+"1.txt");
        //Person person=new Person("张三",12);
        Person person1=new Person("李四",13,"陕西省西安市");
       // 实现对象序列化
        try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(file));) {

            //文件中的二进制数据流
            out.writeObject(person1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //实现对象反序列化
    public static void main(String[] args) {
        code1();
        File file=new File("D:"+File.separator+"javatxt"+File.separator+"1.txt");
        try(ObjectInputStream in=new ObjectInputStream(new FileInputStream(file));){
          Object person= in.readObject();
            System.out.println(person);

        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

    }
}

//定义可以被序列化对象的类
class Person implements Serializable {

    private String name;
    private Integer age;
    private  transient String  address;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}