package com.orienteer.orienteer.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Geocache {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Column(name = "description", nullable = false, length = 100)
    private String description;
    @Column(name = "type", nullable = false, length = 100)
    private String type;
    @Column(name = "owner_id", nullable = false)
    private long ownerId;
    @Column(name = "qr_code", nullable = false, length = 100)
    private String qrCode;
    @Column(name = "created_time", nullable = false)
    private long createdTime;
    @Column(name = "location_name", nullable = false, length = 100)
    private String locationName;
    @Column(name = "longitute", nullable = false)
    private double longitude;
    @Column(name = "latitude", nullable = false)
    private double latitude;
    @Column(name = "points", nullable = false)
    private int points;
    @Column(name = "finder_id", nullable = false)
    private int finderId;
    @Column(name = "is_active", nullable = true)
    private boolean isActive;

    public Geocache(long id, String name, String description, String type, long ownerId, String qrCode, long createdTime, String locationName, double longitude, double latitude, int points, int finderId, boolean isActive) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.ownerId = ownerId;
        this.qrCode = qrCode;
        this.createdTime = createdTime;
        this.locationName = locationName;
        this.longitude = longitude;
        this.latitude = latitude;
        this.points = points;
        this.finderId = finderId;
        this.isActive = isActive;
    }

    public Geocache(long id, String name, String description, String type, long ownerId, boolean isActive) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.ownerId = ownerId;
        this.isActive = isActive;
    }


    public Geocache() {

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

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
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

    public int getFinderId() {
        return finderId;
    }

    public void setFinderId(int finderId) {
        this.finderId = finderId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
