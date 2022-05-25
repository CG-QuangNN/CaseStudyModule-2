package com.company.models;

public class Villa extends Facility {
    /**
     * Tiêu chuẩn phòng
     */
    private String roomStandard;

    /**
     * Diện tích hồ bơi
     */
    private double poolArea;

    /**
     * Số tầng
     */
    private int numberFloors;

    public Villa() {
    }

    public Villa(String facilityId, String name, double area, double price, int maxPeople, int rentalType, String roomStandard, double poolArea, int numberFloors) {
        super(facilityId, name, area, price, maxPeople, rentalType);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.numberFloors = numberFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(int numberFloors) {
        this.numberFloors = numberFloors;
    }

    @Override
    public String toString() {
        return "Villa{" +
                super.toString() +
                "roomStandard='" + roomStandard + '\'' +
                ", poolArea=" + poolArea +
                ", numberFloors=" + numberFloors +
                '}';
    }
}
