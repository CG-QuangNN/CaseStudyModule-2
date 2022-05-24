package com.company.models;

import com.company.utils.MenuUtil;

import java.time.LocalDate;

public abstract class Person {
    /**
     * Mã
     */
    private String id;

    /**
     * Họ tên
     */
    private String fullName;

    /**
     * Ngày sinh
     */
    private LocalDate dateOfBirth;

    /**
     * Giới tính
     * 1 - Nam
     * 2 - Nữ
     * 3 - Giới tính thứ 3
     */
    private int gender;

    /**
     * Số CMND
     */
    private String idCard;

    /**
     * Số Điện Thoại
     */
    private String phoneNumber;

    /**
     * Email
     */
    private String email;

    public Person() {
    }

    public Person(String id, String fullName, LocalDate dateOfBirth, int gender, String idCard, String phoneNumber, String email) {
        this.id = id;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender=" + MenuUtil.parseGender(gender) +
                ", idCard='" + idCard + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'';
    }
}
