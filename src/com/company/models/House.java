package com.company.models;

public class House extends Facility {
    /**
     * Tiêu chuẩn phòng
     */
    private String roomStandard;

    /**
     * Số tầng
     */
    private int numberFloors;

    public House() {
    }

    @Override
    public String getInfo() {
        return null;
    }

    public House(String facilityId, String name, double area, double price, int maxPeople, int rentalType, String roomStandard, int numberFloors) {
        super(facilityId, name, area, price, maxPeople, rentalType);
        this.roomStandard = roomStandard;
        this.numberFloors = numberFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(int numberFloors) {
        this.numberFloors = numberFloors;
    }

    @Override
    public String toString() {
        return "House{" +
                super.toString() +
                "roomStandard='" + roomStandard + '\'' +
                ", numberFloors=" + numberFloors +
                '}';
    }
}
