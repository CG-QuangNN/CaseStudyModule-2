package com.company.models;

import java.time.LocalDate;

public class Booking {
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
     * Tên dịch vụ
     */
    private String serviceName;

    /**
     * Loại dịch vụ.
     */
    private String serviceType;

    public Booking() {
    }

    public Booking(String id, LocalDate startDay, LocalDate endDay, String customerId, String serviceName, String serviceType) {
        this.id = id;
        this.startDay = startDay;
        this.endDay = endDay;
        this.customerId = customerId;
        this.serviceName = serviceName;
        this.serviceType = serviceType;
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

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
}
