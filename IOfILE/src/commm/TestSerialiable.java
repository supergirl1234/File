package commm;


import java.io.*;

/*要想实现序列化，则该类一定要继承Serializable接口*/
/*Serializable默认会将对象中所有属性进行序列化保存，如果现在某些属性不希望被保存了，那么就可以
使用transient关键字*/
class Person implements Serializable{
      public  transient String name;/*不希望name属性被序列化，则在name属性前添加transient关键字，如果希望被序列化，则不添加transient关键字*/
      public int age;
      public String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
public class TestSerialiable {


    public static void serialize1(){

        /*序列化:是将对象转换为二进制，进行传输或保存在文本中*/

        try {
            OutputStream  o=new FileOutputStream(new File("D:/test/output.txt"));
            ObjectOutputStream out=new ObjectOutputStream(o);
            Person person=new Person();
            person.setName("张三");
            person.setAge(12);
            person.setAddress("陕西");
            out.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void FanSerialize1(){

        /*序列化:是将对象转换为二进制，进行传输或保存在文本中*/

        try {
            InputStream  o=new FileInputStream(new File("D:/test/output.txt"));
            ObjectInputStream in=new ObjectInputStream(o);

           Object object=in.readObject();
            System.out.println(object.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {

        /*try {
            ByteArrayOutputStream o=new ByteArrayOutputStream();
            ObjectOutputStream out=new ObjectOutputStream(o);
            Person person=new Person();
            person.setName("张三");
            person.setAge(12);
            person.setAddress("陕西");
            out.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        //serialize1();
        FanSerialize1();
    }
}
