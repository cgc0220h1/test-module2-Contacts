package main;/*
 * @project test-module2-Contacts
 * @author Duc on 4/27/2020
 */

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Contact implements Serializable, Comparable<Contact> {
    private String phoneNumber;
    private String group;
    private String name;
    private boolean gender;
    private String address;
    private LocalDate birthDay;
    private String email;

    public Contact() {
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "Contact" +
                "Phone Number: " + phoneNumber + "\n" +
                "Group: " + group + "\n" +
                "Name: " + name + "\n" +
                "Gender: " + gender +  "\n" +
                "Address: " + address + "\n" +
                "BirthDay: " + birthDay.toString() + "\n" +
                "Email: " + email + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return phoneNumber.equals(contact.phoneNumber) &&
                gender == contact.gender &&
                Objects.equals(group, contact.group) &&
                Objects.equals(name, contact.name) &&
                Objects.equals(address, contact.address) &&
                Objects.equals(birthDay, contact.birthDay) &&
                Objects.equals(email, contact.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber, group, name, gender, address, birthDay, email);
    }

    @Override
    public int compareTo(Contact o) {
        return name.compareTo(o.name);
    }
}
