public class Person {
    @JsonField(name = "first_name")
    private String firstName;

    @JsonField(name = "age")
    private int age;

    private String secret;

    public Person(String firstName, int age, String secret) {
        this.firstName = firstName;
        this.age = age;
        this.secret = secret;
    }
}