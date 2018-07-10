package com.orienteer.orienteer.models;


import javax.persistence.*;
import java.util.List;

import static com.sun.tools.doclint.Entity.copy;


@Entity
@Table(name = "users")
public class User {


    @Id
    @GeneratedValue
    private long id;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "userName", nullable = false , unique = true)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phoneNumber", nullable = false)
    private long phoneNumber;

    @Column(name = "birthday", nullable = false)
    private String birthday;

    @OneToMany
    private List<Geocache> myGeocaches;

    public User(User copy) {
        id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        email = copy.email;
        userName = copy.userName;
        password = copy.password;
    }
//    @OneToMany(mappedBy = "finder")
//    private List<Geocache> foundGeocaches;



    public User(String firstName, String lastName, String userName, String password, String email, long phoneNumber, String birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
    }

    public List<Geocache> getMyGeocaches() {
        return myGeocaches;
    }

    public void setMyGeocaches(List<Geocache> myGeocaches) {
        this.myGeocaches = myGeocaches;
    }

//    public List<Geocache> getFoundGeocaches() {
//        return foundGeocaches;
//    }
//
//    public void setFoundGeocaches(List<Geocache> foundGeocaches) {
//        this.foundGeocaches = foundGeocaches;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }


    public void save(User user) {
    }
}