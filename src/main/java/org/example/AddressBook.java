package org.example;

import jakarta.persistence.*;


import jakarta.persistence.Entity;

import javax.lang.model.element.Name;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
public class AddressBook {
    @OneToMany(cascade = CascadeType.ALL)
    private List<BuddyInfo> addressBook = new ArrayList<>();
    @Id
    @GeneratedValue
    @Column (name = "_id")
    private Long id;

    public AddressBook(){}

    public int addBuddy(BuddyInfo buddy){
        for (BuddyInfo b : this.addressBook){
            if(b.toString().equals(buddy.toString())){
                return 0;
            }
        }
        addressBook.add(buddy);
        return 1;
    }

    public void removeBuddy(BuddyInfo buddy){
        for(BuddyInfo b : this.addressBook){
            if(b.equals(buddy)){
                this.addressBook.remove(b);
                return;
            }
        }
    }

    public List<BuddyInfo> getAddressBook(){
        return addressBook;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
