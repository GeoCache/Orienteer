package com.orienteer.orienteer.models;


import javax.persistence.*;
import java.util.List;

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
    private String phoneNumber;

    @Column(name = "birthday", nullable = false)
    private String birthday;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "finder")
    private List<Geocache> myFinds;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private List<Geocache> myCaches;



    public User(User copy) {
        id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        email = copy.email;
        userName = copy.userName;
        password = copy.password;
    }

    public User(){};




    public User(String firstName, String lastName, String userName, String password, String email, String phoneNumber, String birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
    }


    public List<Geocache> getMyFinds() {
        return myFinds;
    }

    public void setMyFinds(List<Geocache> myFinds) {
        this.myFinds = myFinds;
    }

    public List<Geocache> getMyCaches() {
        return myCaches;
    }

    public void setMyCaches(List<Geocache> myCaches) {
        this.myCaches = myCaches;
    }

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }




}