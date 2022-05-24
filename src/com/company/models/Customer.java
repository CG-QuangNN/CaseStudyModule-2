package com.company.models;

import com.company.utils.MenuUtil;

import java.time.LocalDate;

public class Customer extends Person {
    /**
     * Loại khách
     * 1 - Diamond  - Kim cương
     * 2 - Platinum - Bạch kim
     * 3 - Gold     - Vàng
     * 4 - Silver   - Bạc
     * 5 - Member   - Thành viên
     */
    private int customerType;

    /**
     * Địa chỉ
     */
    private String address;

    public Customer() {
    }

    public Customer(String id, String fullName, LocalDate dateOfBirth, int gender, String idCard, String phoneNumber, String email, int customerType, String address) {
        super(id, fullName, dateOfBirth, gender, idCard, phoneNumber, email);
        this.customerType = customerType;
        this.address = address;
    }

    public int getCustomerType() {
        return customerType;
    }

    public void setCustomerType(int customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                super.toString() +
                "customerType=" + MenuUtil.parseCustomerType(customerType) +
                ", address='" + address + '\'' +
                '}';
    }
}
