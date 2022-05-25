package com.company.models;

import java.time.LocalDate;

public class Booking implements Comparable<Booking> {
    /**
     * Mã booking
     */
    private String id;

    /**
     * Ngày bắt đầu
     */
    private LocalDate startDay;

    /**
     * Ngày kết thúc
     */
    private LocalDate endDay;

    /**
     * Mã khách hàng
     */
    private String customerId;

    /**
     * Mã dịch vụ
     */
    private String facilityId;

    public Booking() {
    }

    public Booking(String id, LocalDate startDay, LocalDate endDay, String customerId, String facilityId) {
        this.id = id;
        this.startDay = startDay;
        this.endDay = endDay;
        this.customerId = customerId;
        this.facilityId = facilityId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getStartDay() {
        return startDay;
    }

    public void setStartDay(LocalDate startDay) {
        this.startDay = startDay;
    }

    public LocalDate getEndDay() {
        return endDay;
    }

    public void setEndDay(LocalDate endDay) {
        this.endDay = endDay;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id='" + id + '\'' +
                ", startDay=" + startDay +
                ", endDay=" + endDay +
                ", customerId='" + customerId + '\'' +
                ", facilityId='" + facilityId + '\'' +
                '}';
    }

    @Override
    public int compareTo(Booking o) {
        int compare = this.startDay.compareTo(o.startDay);
        if (compare != 0) {
            return compare;
        }

        compare = this.endDay.compareTo(o.endDay);
        if (compare != 0) {
            return compare;
        }

        return this.id.compareTo(o.id);
    }
}
