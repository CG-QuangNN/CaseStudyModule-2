package com.company.models;

import com.company.utils.MenuUtil;

public abstract class Facility {
    /**
     * Mã dịch vụ
     */
    private String facilityId;

    /**
     * Tên dịch vụ
     */
    private String name;

    /**
     * Diện tích sử dụng, đơn vị là m2
     */
    private double area;

    /**
     * Chi phí thuê, đơn vị là VND
     */
    private double price;

    /**
     * Số lượng người tối đa
     */
    private int maxPeople;

    /**
     * Kiểu thuê (bao gồm thuê theo năm, tháng, ngày, giờ)
     * 1 - thuê theo năm
     * 2 - thuê theo tháng
     * 3 - thuê theo ngày
     * 4- thuê theo giờ
     */
    private int rentalType;

    public abstract String getInfo();

    public Facility() {
    }

    public Facility(String facilityId, String name, double area, double price, int maxPeople, int rentalType) {
        this.facilityId = facilityId;
        this.name = name;
        this.area = area;
        this.price = price;
        this.maxPeople = maxPeople;
        this.rentalType = rentalType;
    }

    public String getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public int getRentalType() {
        return rentalType;
    }

    public void setRentalType(int rentalType) {
        this.rentalType = rentalType;
    }

    @Override
    public String toString() {
        return "facilityId='" + facilityId + '\'' +
                ", name='" + name + '\'' +
                ", area=" + area +
                ", price=" + price +
                ", maxPeople=" + maxPeople +
                ", rentalType=" + MenuUtil.parseRentalType(rentalType);
    }
}
