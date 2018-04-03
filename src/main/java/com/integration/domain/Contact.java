package com.integration.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

/*
 * a simple domain entity doubling as a DTO
 */
@Entity
@Table(name = "contact")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Contact {

    @Id
    @GeneratedValue()
    private long id;

    @Column(nullable = false)
    private String name;

    @Column()
    private String email;

    @Column()
    String city;

    @Column()
    private int zipcode;

    public Contact() {
    }

    public Contact(String name, String email, int zipcode) {
        this.name = name;
        this.email = email;
        this.zipcode = zipcode;
    }

    public long getId() {
        return this.id;
    }

    // for tests ONLY
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", zipcode=" + zipcode +
                '}';
    }
}
