package com.company.models;

import com.company.utils.MenuUtil;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Employee extends Person {
    /**
     * Trình độ
     * 1 - Trung cấp
     * 2 - Cao đẳng
     * 3 - Đại học
     * 4 - Sau đại học
     */
    private int level;

    /**
     * Vị trí
     */
    private String position;

    /**
     * Lương
     */
    private double salary;

    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s"
                , super.getId()
                , super.getFullName()
                , super.getDateOfBirth()
                , super.getGender()
                , super.getIdCard()
                , super.getPhoneNumber()
                , super.getEmail()
                , this.getLevel()
                , this.getPosition()
                , new BigDecimal(this.getSalary()));
    }

    public Employee() {
    }

    public Employee(String id, String fullName, LocalDate dateOfBirth, int gender, String idCard, String phoneNumber, String email, int level, String position, double salary) {
        super(id, fullName, dateOfBirth, gender, idCard, phoneNumber, email);
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                super.toString() +
                "level=" + MenuUtil.parseLevel(level) +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
