package org.example;

import org.junit.Test;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class BuddyInfoTest {
    @Test
    public void testAnnotations() {
        BuddyInfo b1 = new BuddyInfo();
        BuddyInfo b2 = new BuddyInfo();
        BuddyInfo b3 = new BuddyInfo();
        AddressBook a = new AddressBook();
        b1.setName("Kousha");
        b1.setAddress("1 Main Street");
        b1.setPhoneNumber("1234567");
        b2.setName("Bob");
        b2.setPhoneNumber("0987654");
        b2.setAddress("2 Main Street");
        b3.setAddress("3 Main Street");
        b3.setName("Billy");
        b3.setPhoneNumber("1111111");

        a.addBuddy(b1);
        a.addBuddy(b2);
        a.addBuddy(b3);

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("addressbook");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        entityManager.persist(b1);
        entityManager.persist(b2);

        entityManager.persist(a);

        tx.commit();



    }

}