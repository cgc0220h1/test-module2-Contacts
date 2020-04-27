package main;/*
 * @project test-module2-Contacts
 * @author Duc on 4/27/2020
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Manager {
    private List<Contact> contacts;

    public Manager() {
        contacts = new ArrayList<>();
    }

    public void add(Contact contact) {
        contacts.add(contact);
        contacts.sort(Comparator.naturalOrder());
    }

    public void remove(Contact contact) {
        contacts.remove(contact);
    }

    public Contact searchByNumber(String number) {
        for (Contact contact : contacts) {
            if (contact.getPhoneNumber().equals(number)) {
                return contact;
            }
        }
        return null;
    }

    public Contact searchNumberRelatively(String number) {
        for (Contact contact : contacts) {
            if (contact.getName().contains(number)) {
                return contact;
            }
        }
        return null;
    }

    public Contact searchByName(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equals(name)) {
                return contact;
            }
        }
        return null;
    }

    public Contact searchNameRelatively(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().contains(name)) {
                return contact;
            }
        }
        return null;
    }

    public boolean checkStatus() {
        return contacts.isEmpty();
    }

    public List<Contact> getContactsList() {
        return contacts;
    }
}
