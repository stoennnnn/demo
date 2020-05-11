package src;

public class Test {
    public static void main(String[] args) {
        // ObjectInputStream ois = new ObjectInputStream(is);
        // ObjectInputStream ois = new SerialKiller(is, "C:\\Users\\Administrator\\Desktop\\seriable\\serialkiller.conf");
        //序列化
        Person person = new Person();
        person.setName("混世魔王");
        SerializationUtil.writeObject(person);

        Person p = (Person) SerializationUtil.readObject();
        System.out.println("name = " + p.getName());
    }
}
