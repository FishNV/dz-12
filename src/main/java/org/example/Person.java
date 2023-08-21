package org.example;

public abstract class Person {

    final private String firstName;
    private String lastName;
    private final String lastNameBeforeChange;
    private int age;
    public Person partner;

    public Person (String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastNameBeforeChange = lastName;
        this.age = age;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLastNameBeforeChange() {
        return lastNameBeforeChange;
    }

    public abstract boolean isRetired();

    public abstract void registerPartnership(Person partner);

    public abstract void deregisterPartnership(boolean returnToMaidenName);

}
