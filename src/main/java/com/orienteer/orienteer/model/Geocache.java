package com.orienteer.orienteer.model;

public class Geocache {
    private long id;
    private String name;
    private String description;
    private String type;
    private long ownerId;
    private String qrCode;
    private long createdTime;
    private String locationName;
    private double longitude;
    private double latitude;
    private int points;
    private int finderId;
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
