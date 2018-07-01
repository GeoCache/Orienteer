package com.orienteer.orienteer.models;

import javax.persistence.*;

@Entity
public class Geocache {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Column(name = "description", nullable = false, length = 300)
    private String description;
    @Column(name = "type", nullable = false, length = 20)
    private String type;
    @Column(name = "qr_code", nullable = false, length = 100)
    private String qrCode;
    @Column(name = "created_time", nullable = false)
    private long createdTime;
    @Column(name = "location_name", nullable = false, length = 100)
    private String locationName;
    @Column(name = "longitude", nullable = false)
    private double longitude;
    @Column(name = "latitude", nullable = false)
    private double latitude;
    @Column(name = "points", nullable = false)
    private int points;
    @Column(name = "active", nullable = false)
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "finder_id", nullable = true)
    private User finder;


    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;


    public Geocache(long id, String name, String description, String type, User owner, String qrCode, long createdTime, String locationName, double longitude, double latitude, int points, boolean isActive) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.qrCode = qrCode;
        this.createdTime = createdTime;
        this.locationName = locationName;
        this.longitude = longitude;
        this.latitude = latitude;
        this.points = points;
        this.isActive = isActive;
        this.owner = owner;
    }


    public Geocache() {

    }

    public User getFinder() {
        return finder;
    }

    public void setFinder(User finder) {
        this.finder = finder;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
