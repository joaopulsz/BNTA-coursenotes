
public class Main {

    public static void main(String[] args) {

        Person person1 = new Person("Colin", "Bathgate");
        Person person2 = new Person("Anna", "Glasgow");

        System.out.println(person1.getName());

        person1.setName("Richard");

        System.out.println(person1.getName());

    }

}
