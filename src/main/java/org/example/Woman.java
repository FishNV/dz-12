package org.example;

public class Woman extends Person {

    public Woman(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }

    @Override
    public void registerPartnership(Person partner) {
        this.partner = partner;
        partner.partner = this;
        setLastName(partner.getLastName());
    }

    @Override
    public void deregisterPartnership(boolean returnToMaidenName) {
        partner.partner = null;
        partner = null;
        if (returnToMaidenName) {
            setLastName(getLastNameBeforeChange());
        }
    }

    @Override
    public boolean isRetired() {
        return getAge() >= 60;
    }
}
