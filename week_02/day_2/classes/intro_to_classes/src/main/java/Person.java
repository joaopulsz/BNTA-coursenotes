public class Person {

    private String name;
    private String town;
    private int age;

    public Person(String newPersonName, String newPersonTown){
        this.name = newPersonName;
        this.town = newPersonTown;
        this.age = 0;
    }


    // METHODS

    public void greet(String timeOfDay){
        System.out.println("Good " + timeOfDay + "!");
    }

    public String generateBio(){
        return "My name is " + this.name + " and I live in " + this.town + ".";
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

}
