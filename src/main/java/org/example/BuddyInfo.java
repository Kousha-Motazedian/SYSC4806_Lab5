package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class BuddyInfo
{

    private String name;

    private String phoneNumber;
    private String address;
    @Id
    @GeneratedValue
    private Long id;

    public BuddyInfo() {}
    public BuddyInfo(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String number){
        this.phoneNumber = number;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Name: " + name + " Address: " + address + " Phone Number: " + phoneNumber;
    }

    @Override
    public boolean equals(Object b) {
        BuddyInfo b1;
        if (b instanceof BuddyInfo) {
            b1 = (BuddyInfo) b;
        }
        else {
            return false;
        }
        return b1.name.equals(this.name) && b1.address.equals(this.address) && b1.phoneNumber.equals(this.phoneNumber);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

