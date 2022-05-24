package com.company.models;

public class Room extends Facility {
    /**
     * Dịch vụ miễn phí đi kèm
     */
    private String freeService;

    public Room() {
    }

    public Room(String name, double area, double price, int maxPeople, int rentalType, String freeService) {
        super(name, area, price, maxPeople, rentalType);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return "Room{" +
                super.toString() +
                "freeService='" + freeService + '\'' +
                '}';
    }
}
