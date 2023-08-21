package org.example;

public class Man extends Person {

    public Man(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }

    @Override
    public void registerPartnership(Person partner) {
        this.partner = partner;
        partner.partner = this;
        partner.setLastName(getLastName());
    }

    @Override
    public void deregisterPartnership(boolean returnToMaidenName) {
        if (returnToMaidenName) {
            partner.setLastName(partner.getLastNameBeforeChange());
        }
        partner.partner = null;
        partner = null;
    }

    @Override
    public boolean isRetired() {
        return getAge() >= 65;
    }
}
