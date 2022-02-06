package property;

public class PersonWithJava {
    private final String name;
    private int age;

    public PersonWithJava(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public final String getName() {
        return name;
    }

    public final int getAge() {
        return age;
    }

    public final void setAge(int age) {
        this.age = age;
    }
}
